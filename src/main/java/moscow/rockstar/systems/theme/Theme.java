package moscow.rockstar.systems.theme;

import lombok.Generated;
import moscow.rockstar.utility.colors.ColorRGBA;

public enum Theme implements CustomTheme {
   DARK(
      new ColorRGBA(255.0F, 255.0F, 255.0F),
      new ColorRGBA(12.0F, 12.0F, 12.0F),
      new ColorRGBA(24.0F, 24.0F, 27.0F),
      new ColorRGBA(32.0F, 32.0F, 32.0F),
      ColorRGBA.BLACK
   ),
   LIGHT(
      new ColorRGBA(10.0F, 10.0F, 10.0F),
      new ColorRGBA(229.0F, 229.0F, 229.0F),
      new ColorRGBA(255.0F, 255.0F, 255.0F),
      new ColorRGBA(32.0F, 32.0F, 32.0F),
      ColorRGBA.WHITE
   );

   private ColorRGBA textColor;
   private ColorRGBA backgroundColor;
   private ColorRGBA additionalColor;
   private ColorRGBA outlineColor;
   private ColorRGBA flatColor;
   private ColorRGBA accentColor = new ColorRGBA(151.0F, 71.0F, 255.0F);
   private ColorRGBA iconsColor = ColorRGBA.WHITE;
   private ColorRGBA enabledModulesColor = ColorRGBA.WHITE;
   private final ColorRGBA defaultTextColor;
   private final ColorRGBA defaultBackgroundColor;
   private final ColorRGBA defaultAdditionalColor;
   private final ColorRGBA defaultOutlineColor;
   private final ColorRGBA defaultFlatColor;
   private final boolean separators = true;
   private final float blurStrength = 4.0F;
   private final float glassOpacity = 20.0F;
   private final float minimalismOpacity = 80.0F;
   private final float enabledOffset = 2.0F;
   private final float hudRounding = 7.0F;
   private final float blurOffset = 0.5F;
   private final float hudAlpha = 0.8F;
   private final float disableAlphaGlass = 0.2F;
   private final float glassPower = 25.0F;
   private final float glassStrength = 0.08F;
   private final float padding = 2.0F;
   private final float splitters = 1.0F;
   private final float albumColor = 1.0F;

   @Generated
   @Override
   public ColorRGBA getTextColor() {
      return this.textColor;
   }

   public void setTextColor(ColorRGBA textColor) {
      this.textColor = textColor;
   }

   @Generated
   @Override
   public ColorRGBA getBackgroundColor() {
      return this.backgroundColor;
   }

   public void setBackgroundColor(ColorRGBA backgroundColor) {
      this.backgroundColor = backgroundColor;
   }

   @Generated
   @Override
   public ColorRGBA getAdditionalColor() {
      return this.additionalColor;
   }

   public void setAdditionalColor(ColorRGBA additionalColor) {
      this.additionalColor = additionalColor;
   }

   @Generated
   @Override
   public ColorRGBA getOutlineColor() {
      return this.outlineColor;
   }

   public void setOutlineColor(ColorRGBA outlineColor) {
      this.outlineColor = outlineColor;
   }

   @Generated
   @Override
   public ColorRGBA getFlatColor() {
      return this.flatColor;
   }

   public void setFlatColor(ColorRGBA flatColor) {
      this.flatColor = flatColor;
   }

   @Override
   public ColorRGBA getAccentColor() {
      return this.accentColor;
   }

   public void setAccentColor(ColorRGBA accentColor) {
      this.accentColor = accentColor;
   }

   @Override
   public ColorRGBA getIconsColor() {
      return this.iconsColor;
   }

   public void setIconsColor(ColorRGBA iconsColor) {
      this.iconsColor = iconsColor;
   }

   @Override
   public ColorRGBA getEnabledModulesColor() {
      return this.enabledModulesColor;
   }

   public void setEnabledModulesColor(ColorRGBA enabledModulesColor) {
      this.enabledModulesColor = enabledModulesColor;
   }

   @Override
   public String getName() {
      return this.name();
   }

   @Override
   public boolean isDark() {
      return this == DARK;
   }

   @Override
   public boolean isSeparators() {
      return true;
   }

   @Override
   public float getBlurStrength() {
      return 4.0F;
   }

   @Override
   public float getGlassOpacity() {
      return 20.0F;
   }

   @Override
   public float getMinimalismOpacity() {
      return 80.0F;
   }

   @Override
   public float getEnabledOffset() {
      return 2.0F;
   }

   @Override
   public float getHudRounding() {
      return 7.0F;
   }

   @Override
   public float getBlurOffset() {
      return 0.5F;
   }

   @Override
   public float getHudAlpha() {
      return 0.8F;
   }

   @Override
   public float getDisableAlphaGlass() {
      return 0.2F;
   }

   @Override
   public float getGlassPower() {
      return 25.0F;
   }

   @Override
   public float getGlassStrength() {
      return 0.08F;
   }

   @Override
   public float getPadding() {
      return 2.0F;
   }

   @Override
   public float getSplitters() {
      return 1.0F;
   }

   @Override
   public float getAlbumColor() {
      return 1.0F;
   }

    @Generated
    Theme(final ColorRGBA textColor, final ColorRGBA backgroundColor, final ColorRGBA additionalColor, final ColorRGBA outlineColor, final ColorRGBA flatColor) {
       this.textColor = textColor;
       this.backgroundColor = backgroundColor;
       this.additionalColor = additionalColor;
       this.outlineColor = outlineColor;
       this.flatColor = flatColor;
       this.defaultTextColor = textColor;
       this.defaultBackgroundColor = backgroundColor;
       this.defaultAdditionalColor = additionalColor;
       this.defaultOutlineColor = outlineColor;
       this.defaultFlatColor = flatColor;
    }

    @Override
    public void resetToDefault() {
       this.textColor = this.defaultTextColor;
       this.backgroundColor = this.defaultBackgroundColor;
       this.additionalColor = this.defaultAdditionalColor;
       this.outlineColor = this.defaultOutlineColor;
       this.flatColor = this.defaultFlatColor;
       this.accentColor = new ColorRGBA(151.0F, 71.0F, 255.0F);
       this.iconsColor = ColorRGBA.WHITE;
       this.enabledModulesColor = ColorRGBA.WHITE;
    }
}
