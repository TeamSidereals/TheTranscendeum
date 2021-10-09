// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelKefgaell extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer body_r4;
	private final ModelRenderer body_r5;
	private final ModelRenderer body_r6;
	private final ModelRenderer body_r7;
	private final ModelRenderer body_r8;
	private final ModelRenderer body_r9;
	private final ModelRenderer body_r10;
	private final ModelRenderer body_r11;
	private final ModelRenderer body_r12;
	private final ModelRenderer body_r13;
	private final ModelRenderer body_r14;
	private final ModelRenderer body_r15;
	private final ModelRenderer body_r16;
	private final ModelRenderer jaw;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public ModelKefgaell() {
		textureWidth = 256;
		textureHeight = 256;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, 4.5F);
		head.setTextureOffset(58, 34).addBox(-12.3889F, -12.0F, -13.3472F, 25.0F, 14.0F, 26.0F, 0.0F, false);
		head.setTextureOffset(12, 10).addBox(-12.4F, 2.0F, -13.3472F, 4.0F, 3.0F, 2.0F, 0.0F, true);
		head.setTextureOffset(12, 0).addBox(-12.4F, 2.0F, -11.3472F, 2.0F, 3.0F, 7.0F, 0.0F, true);
		head.setTextureOffset(28, 60).addBox(-4.3889F, 2.0F, -13.3472F, 9.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(12, 10).addBox(8.6111F, 2.0F, -13.3472F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(12, 0).addBox(10.6111F, 2.0F, -11.3472F, 2.0F, 3.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(12, 0).addBox(10.6111F, 2.0F, -1.3472F, 2.0F, 3.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(12, 0).addBox(-12.4F, 2.0F, -1.3472F, 2.0F, 3.0F, 7.0F, 0.0F, true);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.6111F, 17.0F, -4.8472F);
		head.addChild(body_r1);
		setRotationAngle(body_r1, -0.3927F, 0.0F, 0.0F);
		body_r1.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);
		body_r1.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);
		body_r1.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(0.6111F, 17.0F, -4.8472F);
		head.addChild(body_r2);
		setRotationAngle(body_r2, -0.8727F, 0.0F, 0.0F);
		body_r2.setTextureOffset(0, 0).addBox(-14.0F, -26.0F, -52.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);
		body_r2.setTextureOffset(0, 0).addBox(-14.0F, -26.0F, -52.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r3 = new ModelRenderer(this);
		body_r3.setRotationPoint(-1.3889F, 17.0F, -1.8472F);
		head.addChild(body_r3);
		setRotationAngle(body_r3, 0.0F, 1.5708F, 0.8727F);
		body_r3.setTextureOffset(0, 0).addBox(-14.0F, -26.0F, -52.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r4 = new ModelRenderer(this);
		body_r4.setRotationPoint(-1.3889F, 17.0F, -1.8472F);
		head.addChild(body_r4);
		setRotationAngle(body_r4, 0.0F, 1.5708F, 0.3927F);
		body_r4.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r5 = new ModelRenderer(this);
		body_r5.setRotationPoint(3.6111F, 17.0F, -0.8472F);
		head.addChild(body_r5);
		setRotationAngle(body_r5, 0.0F, -1.5708F, -0.3927F);
		body_r5.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r6 = new ModelRenderer(this);
		body_r6.setRotationPoint(3.6111F, 17.0F, -0.8472F);
		head.addChild(body_r6);
		setRotationAngle(body_r6, 0.0F, -1.5708F, -0.8727F);
		body_r6.setTextureOffset(0, 0).addBox(-14.0F, -26.0F, -52.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r7 = new ModelRenderer(this);
		body_r7.setRotationPoint(0.6111F, 17.0F, 4.1528F);
		head.addChild(body_r7);
		setRotationAngle(body_r7, 2.2689F, 0.0F, -3.1416F);
		body_r7.setTextureOffset(0, 0).addBox(-14.0F, -26.0F, -52.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r8 = new ModelRenderer(this);
		body_r8.setRotationPoint(0.6111F, 17.0F, 4.1528F);
		head.addChild(body_r8);
		setRotationAngle(body_r8, 2.7489F, 0.0F, -3.1416F);
		body_r8.setTextureOffset(0, 30).addBox(-14.0F, -34.0F, -38.5F, 27.0F, 0.0F, 30.0F, 0.0F, false);

		body_r9 = new ModelRenderer(this);
		body_r9.setRotationPoint(14.6111F, 17.0F, 0.1528F);
		head.addChild(body_r9);
		setRotationAngle(body_r9, -0.0436F, -0.6981F, 0.0F);
		body_r9.setTextureOffset(0, 74).addBox(-22.0F, -34.0F, -23.5F, 23.0F, 5.0F, 28.0F, 0.0F, false);

		body_r10 = new ModelRenderer(this);
		body_r10.setRotationPoint(13.3889F, 17.0F, -13.1528F);
		head.addChild(body_r10);
		setRotationAngle(body_r10, 0.0436F, -0.6981F, 0.0F);
		body_r10.setTextureOffset(0, 74).addBox(-15.0F, -33.0F, 24.5F, 23.0F, 5.0F, 28.0F, 0.0F, true);

		body_r11 = new ModelRenderer(this);
		body_r11.setRotationPoint(18.2889F, 16.0F, -9.1528F);
		head.addChild(body_r11);
		setRotationAngle(body_r11, -3.098F, -0.8727F, 3.1416F);
		body_r11.setTextureOffset(0, 74).addBox(6.0F, -32.0F, 13.5F, 23.0F, 5.0F, 28.0F, 0.0F, true);

		body_r12 = new ModelRenderer(this);
		body_r12.setRotationPoint(19.5111F, 16.0F, 4.1528F);
		head.addChild(body_r12);
		setRotationAngle(body_r12, 3.098F, -0.8727F, -3.1416F);
		body_r12.setTextureOffset(0, 74).addBox(0.0F, -33.0F, -16.5F, 23.0F, 5.0F, 28.0F, 0.0F, false);

		body_r13 = new ModelRenderer(this);
		body_r13.setRotationPoint(5.5111F, 15.0F, -0.8472F);
		head.addChild(body_r13);
		setRotationAngle(body_r13, 0.0F, -1.5708F, -0.0436F);
		body_r13.setTextureOffset(0, 74).addBox(-12.0F, -33.0F, -23.5F, 23.0F, 5.0F, 28.0F, 0.0F, false);

		body_r14 = new ModelRenderer(this);
		body_r14.setRotationPoint(4.2889F, 15.0F, -14.1528F);
		head.addChild(body_r14);
		setRotationAngle(body_r14, 0.0F, -1.5708F, 0.0436F);
		body_r14.setTextureOffset(0, 74).addBox(4.0F, -32.0F, 5.5F, 23.0F, 5.0F, 28.0F, 0.0F, true);

		body_r15 = new ModelRenderer(this);
		body_r15.setRotationPoint(-0.6111F, 16.0F, -18.1528F);
		head.addChild(body_r15);
		setRotationAngle(body_r15, 0.0436F, 0.0F, 0.0F);
		body_r15.setTextureOffset(0, 74).addBox(-11.0F, -33.0F, 19.5F, 23.0F, 5.0F, 28.0F, 0.0F, true);

		body_r16 = new ModelRenderer(this);
		body_r16.setRotationPoint(0.6111F, 16.0F, -4.8472F);
		head.addChild(body_r16);
		setRotationAngle(body_r16, -0.0436F, 0.0F, 0.0F);
		body_r16.setTextureOffset(0, 74).addBox(-12.0F, -34.0F, -23.5F, 23.0F, 5.0F, 28.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-1.0F, 2.0F, 11.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3491F, 0.0F, 0.0F);
		jaw.setTextureOffset(76, 81).addBox(-11.3889F, -0.3808F, -24.5187F, 25.0F, 3.0F, 26.0F, 0.0F, false);
		jaw.setTextureOffset(28, 60).addBox(-3.3889F, -3.3808F, -24.5187F, 9.0F, 3.0F, 2.0F, 0.0F, false);
		jaw.setTextureOffset(12, 10).addBox(9.6111F, -3.3808F, -24.5187F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		jaw.setTextureOffset(12, 0).addBox(11.6111F, -3.3808F, -22.5187F, 2.0F, 3.0F, 7.0F, 0.0F, false);
		jaw.setTextureOffset(12, 10).addBox(-11.4F, -3.3808F, -24.5187F, 4.0F, 3.0F, 2.0F, 0.0F, true);
		jaw.setTextureOffset(12, 0).addBox(-11.4F, -3.3808F, -22.5187F, 2.0F, 3.0F, 7.0F, 0.0F, true);
		jaw.setTextureOffset(12, 0).addBox(11.6111F, -3.3808F, -12.5187F, 2.0F, 3.0F, 7.0F, 0.0F, false);
		jaw.setTextureOffset(12, 0).addBox(-11.4F, -3.3808F, -12.5187F, 2.0F, 3.0F, 7.0F, 0.0F, true);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-6.0F, 1.6192F, -20.1715F);
		jaw.addChild(leg1);
		leg1.setTextureOffset(0, 0).addBox(-1.2222F, 0.0F, -1.2639F, 3.0F, 43.0F, 3.0F, 0.0F, false);
		leg1.setTextureOffset(0, 46).addBox(-3.2222F, 43.0F, -3.2639F, 7.0F, 10.0F, 7.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(8.0F, 1.6192F, -18.1715F);
		jaw.addChild(leg2);
		leg2.setTextureOffset(0, 0).addBox(-1.2222F, 0.0F, -1.2639F, 3.0F, 43.0F, 3.0F, 0.0F, false);
		leg2.setTextureOffset(0, 63).addBox(-3.2222F, 43.0F, -3.2639F, 7.0F, 10.0F, 7.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(5.0F, 1.6192F, -3.1715F);
		jaw.addChild(leg3);
		leg3.setTextureOffset(0, 0).addBox(-1.2222F, 0.0F, -1.2639F, 3.0F, 43.0F, 3.0F, 0.0F, false);
		leg3.setTextureOffset(0, 46).addBox(-3.2222F, 43.0F, -3.2639F, 7.0F, 10.0F, 7.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-4.0F, 1.6192F, -9.1715F);
		jaw.addChild(leg4);
		leg4.setTextureOffset(0, 0).addBox(-1.2222F, 0.0F, -1.2639F, 3.0F, 43.0F, 3.0F, 0.0F, false);
		leg4.setTextureOffset(0, 63).addBox(-3.2222F, 43.0F, -3.2639F, 7.0F, 10.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.jaw.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}