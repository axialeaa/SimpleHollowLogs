package com.axialeaa.simplehollowlogs.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@SuppressWarnings("deprecation")
public class HollowLogBlock extends PillarBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final VoxelShape X_SHAPE = createHollowLogShape(Block.createCuboidShape(0.0, 3.0, 3.0, 16.0, 13.0, 13.0));
    public static final VoxelShape Y_SHAPE = createHollowLogShape(Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0));
    public static final VoxelShape Z_SHAPE = createHollowLogShape(Block.createCuboidShape(3.0, 3.0, 0.0, 13.0, 13.0, 16.0));

    private static VoxelShape createHollowLogShape(VoxelShape holeShape) {
        return VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), holeShape, BooleanBiFunction.ONLY_FIRST);
        // construct voxelshapes by subtracting a hole from a full cube
        // this is more optimised than the previously devised method of stitching 4 relevant sides together from a list of a possible 6
    }

    private final BlockState strippedState;

    public HollowLogBlock(BlockState strippedState, Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.AXIS, Direction.Axis.Y).with(WATERLOGGED, false));
        this.strippedState = strippedState;
        // the strippedState parameter looks for a blockstate it can use for the axe stripping functionality,
        // which we have to write from scratch due to fabric api's strippable block registry looking for a block with only an axis property,
        // ignoring waterlogging in this case
    }

    public BlockState getStrippedState() {
        return this.strippedState;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis()).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED))
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private VoxelShape getShape(BlockState state) {
        return switch (state.get(AXIS)) {
            case X -> X_SHAPE;
            case Y -> Y_SHAPE;
            case Z -> Z_SHAPE;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShape(state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShape(state);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return getShape(state);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand); // find the item that the player is holding
        if (getStrippedState() != null && itemStack.getItem() instanceof AxeItem) {
            // if the blockstate set as the strippedState param of the constructor is not null and the item is a type of axe...
            world.setBlockState(pos, getStrippedState().with(AXIS, state.get(AXIS)).with(WATERLOGGED, state.get(WATERLOGGED)));
            world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            // set the blockstate at this position to the strippedState, conserving the axis and waterlogged properties, and play the stripping sound
            if (!player.isCreative()) itemStack.damage(1, player, p -> p.sendToolBreakStatus(hand));
            // if the player is in survival mode, decrement the durability of the axe
            return ActionResult.SUCCESS;
            // finally, make the hand visually swing to indicate an action just completed
        }
        return ActionResult.PASS; // otherwise do nothing and don't swing the hand
    }

}