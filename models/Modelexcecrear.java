// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelexcecrear extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer flower;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer head_r5;
	private final ModelRenderer head_r6;
	private final ModelRenderer head_r7;
	private final ModelRenderer head_r8;
	private final ModelRenderer head_r9;
	private final ModelRenderer head_r10;
	private final ModelRenderer head_r11;
	private final ModelRenderer head_r12;
	private final ModelRenderer head_r13;
	private final ModelRenderer head_r14;
	private final ModelRenderer head_r15;
	private final ModelRenderer head_r16;
	private final ModelRenderer body;
	private final ModelRenderer rotation;
	private final ModelRenderer rotation_r1;
	private final ModelRenderer rotation_r2;
	private final ModelRenderer backleg1;
	private final ModelRenderer frontleg1;
	private final ModelRenderer leg4_r1;
	private final ModelRenderer leg3_r1;
	private final ModelRenderer leg2_r1;
	private final ModelRenderer backleg2;
	private final ModelRenderer frontleg2;
	private final ModelRenderer leg5_r1;
	private final ModelRenderer leg4_r2;
	private final ModelRenderer leg3_r2;

	public Modelexcecrear() {
		textureWidth = 256;
		textureHeight = 256;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -10.5F, -1.0F);
		head.setTextureOffset(0, 79).addBox(-10.5F, -9.0F, -10.0F, 21.0F, 10.0F, 21.0F, 0.0F, false);

		flower = new ModelRenderer(this);
		flower.setRotationPoint(0.0F, 22.0F, -16.0F);
		head.addChild(flower);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, -1.5708F, -0.4363F);
		head_r1.setTextureOffset(38, 0).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r2);
		setRotationAngle(head_r2, 0.0F, 1.5708F, 0.829F);
		head_r2.setTextureOffset(0, 34).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r3);
		setRotationAngle(head_r3, 0.0F, 1.5708F, 0.4363F);
		head_r3.setTextureOffset(38, 0).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r4);
		setRotationAngle(head_r4, 0.0F, -1.5708F, -0.829F);
		head_r4.setTextureOffset(0, 34).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r5 = new ModelRenderer(this);
		head_r5.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r5);
		setRotationAngle(head_r5, 2.3126F, 0.0F, 3.1416F);
		head_r5.setTextureOffset(0, 34).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r6 = new ModelRenderer(this);
		head_r6.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r6);
		setRotationAngle(head_r6, 2.7053F, 0.0F, 3.1416F);
		head_r6.setTextureOffset(38, 0).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r7 = new ModelRenderer(this);
		head_r7.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r7);
		setRotationAngle(head_r7, -0.829F, 0.0F, 0.0F);
		head_r7.setTextureOffset(0, 34).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r8 = new ModelRenderer(this);
		head_r8.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r8);
		setRotationAngle(head_r8, -0.4363F, 0.0F, 0.0F);
		head_r8.setTextureOffset(38, 0).addBox(-10.5F, -5.5F, -28.0F, 21.0F, 0.0F, 28.0F, 0.0F, false);

		head_r9 = new ModelRenderer(this);
		head_r9.setRotationPoint(0.0F, -30.5F, 17.0F);
		flower.addChild(head_r9);
		setRotationAngle(head_r9, 3.0543F, -0.7854F, -3.1416F);
		head_r9.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, -28.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r10 = new ModelRenderer(this);
		head_r10.setRotationPoint(0.0F, -30.5F, 17.0F);
		flower.addChild(head_r10);
		setRotationAngle(head_r10, -3.0543F, -0.7854F, 3.1416F);
		head_r10.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, 0.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r11 = new ModelRenderer(this);
		head_r11.setRotationPoint(0.0F, -30.5F, 17.0F);
		flower.addChild(head_r11);
		setRotationAngle(head_r11, 0.0873F, -0.7854F, 0.0F);
		head_r11.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, 0.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r12 = new ModelRenderer(this);
		head_r12.setRotationPoint(0.0F, -30.5F, 17.0F);
		flower.addChild(head_r12);
		setRotationAngle(head_r12, -0.0873F, -0.7854F, 0.0F);
		head_r12.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, -28.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r13 = new ModelRenderer(this);
		head_r13.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r13);
		setRotationAngle(head_r13, 0.0F, -1.5708F, 0.0873F);
		head_r13.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, 0.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r14 = new ModelRenderer(this);
		head_r14.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r14);
		setRotationAngle(head_r14, 0.0F, -1.5708F, -0.0873F);
		head_r14.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, -28.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r15 = new ModelRenderer(this);
		head_r15.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r15);
		setRotationAngle(head_r15, 0.0873F, 0.0F, 0.0F);
		head_r15.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, 0.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		head_r16 = new ModelRenderer(this);
		head_r16.setRotationPoint(0.0F, -31.5F, 17.0F);
		flower.addChild(head_r16);
		setRotationAngle(head_r16, -0.0873F, 0.0F, 0.0F);
		head_r16.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, -28.0F, 19.0F, 6.0F, 28.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 14.0F, 0.0F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, -4.0F, 0.0F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.setTextureOffset(46, 38).addBox(-8.5F, -9.0F, -4.5F, 17.0F, 17.0F, 24.0F, 0.0F, false);

		rotation_r1 = new ModelRenderer(this);
		rotation_r1.setRotationPoint(0.0F, 14.0F, 0.0F);
		rotation.addChild(rotation_r1);
		setRotationAngle(rotation_r1, 0.0F, 0.0F, -0.3927F);
		rotation_r1.setTextureOffset(60, 79).addBox(-15.5F, -17.0F, -4.5F, 14.0F, 0.0F, 24.0F, 0.0F, true);

		rotation_r2 = new ModelRenderer(this);
		rotation_r2.setRotationPoint(0.0F, 14.0F, 0.0F);
		rotation.addChild(rotation_r2);
		setRotationAngle(rotation_r2, 0.0F, 0.0F, 0.3927F);
		rotation_r2.setTextureOffset(60, 79).addBox(1.5F, -17.0F, -4.5F, 14.0F, 0.0F, 24.0F, 0.0F, false);

		backleg1 = new ModelRenderer(this);
		backleg1.setRotationPoint(-5.5F, 15.0F, 6.0F);
		backleg1.setTextureOffset(75, 103).addBox(-7.0F, -2.0F, -4.0F, 10.0F, 11.0F, 9.0F, 0.0F, false);

		frontleg1 = new ModelRenderer(this);
		frontleg1.setRotationPoint(-5.5F, 11.0F, -8.0F);
		setRotationAngle(frontleg1, 0.0F, 0.4363F, 0.0F);

		leg4_r1 = new ModelRenderer(this);
		leg4_r1.setRotationPoint(-0.5F, 2.0F, 16.0F);
		frontleg1.addChild(leg4_r1);
		setRotationAngle(leg4_r1, -0.5672F, 0.0F, 0.0F);
		leg4_r1.setTextureOffset(0, 34).addBox(-4.5F, 13.0F, -30.0F, 6.0F, 17.0F, 6.0F, 0.0F, false);

		leg3_r1 = new ModelRenderer(this);
		leg3_r1.setRotationPoint(-0.5F, 2.0F, 16.0F);
		frontleg1.addChild(leg3_r1);
		setRotationAngle(leg3_r1, 0.9163F, 0.0F, 0.0F);
		leg3_r1.setTextureOffset(0, 0).addBox(-5.5F, -26.0F, -20.0F, 8.0F, 14.0F, 6.0F, 0.0F, false);

		leg2_r1 = new ModelRenderer(this);
		leg2_r1.setRotationPoint(-0.5F, 2.0F, 16.0F);
		frontleg1.addChild(leg2_r1);
		setRotationAngle(leg2_r1, -0.7854F, 0.0F, 0.0F);
		leg2_r1.setTextureOffset(0, 57).addBox(-4.5F, 8.0F, -16.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		backleg2 = new ModelRenderer(this);
		backleg2.setRotationPoint(6.5F, 15.0F, 6.0F);
		backleg2.setTextureOffset(75, 103).addBox(-3.0F, -2.0F, -4.0F, 10.0F, 11.0F, 9.0F, 0.0F, false);

		frontleg2 = new ModelRenderer(this);
		frontleg2.setRotationPoint(5.5F, 11.0F, -8.0F);
		setRotationAngle(frontleg2, 0.0F, -0.4363F, 0.0F);

		leg5_r1 = new ModelRenderer(this);
		leg5_r1.setRotationPoint(0.5F, 2.0F, 16.0F);
		frontleg2.addChild(leg5_r1);
		setRotationAngle(leg5_r1, -0.5672F, 0.0F, 0.0F);
		leg5_r1.setTextureOffset(0, 34).addBox(-1.5F, 13.0F, -30.0F, 6.0F, 17.0F, 6.0F, 0.0F, true);

		leg4_r2 = new ModelRenderer(this);
		leg4_r2.setRotationPoint(0.5F, 2.0F, 16.0F);
		frontleg2.addChild(leg4_r2);
		setRotationAngle(leg4_r2, 0.9163F, 0.0F, 0.0F);
		leg4_r2.setTextureOffset(0, 0).addBox(-2.5F, -26.0F, -20.0F, 8.0F, 14.0F, 6.0F, 0.0F, true);

		leg3_r2 = new ModelRenderer(this);
		leg3_r2.setRotationPoint(0.5F, 2.0F, 16.0F);
		frontleg2.addChild(leg3_r2);
		setRotationAngle(leg3_r2, -0.7854F, 0.0F, 0.0F);
		leg3_r2.setTextureOffset(0, 57).addBox(-1.5F, 8.0F, -16.0F, 6.0F, 11.0F, 6.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		backleg1.render(matrixStack, buffer, packedLight, packedOverlay);
		frontleg1.render(matrixStack, buffer, packedLight, packedOverlay);
		backleg2.render(matrixStack, buffer, packedLight, packedOverlay);
		frontleg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.frontleg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.frontleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.backleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.backleg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}