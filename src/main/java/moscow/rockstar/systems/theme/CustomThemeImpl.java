package moscow.rockstar.systems.theme;

import moscow.rockstar.utility.colors.ColorRGBA;

public class CustomThemeImpl implements CustomTheme {
   private final String name;
   private final boolean dark;
   private final ColorRGBA defaultTextColor;
   private final ColorRGBA defaultBackgroundColor;
   private final ColorRGBA defaultAdditionalColor;
   private final ColorRGBA defaultOutlineColor;
   private final ColorRGBA defaultFlatColor;
   private final ColorRGBA defaultAccentColor;
   private final ColorRGBA defaultIconsColor;
   private final ColorRGBA defaultEnabledModulesColor;
   private ColorRGBA textColor;
   private ColorRGBA backgroundColor;
   private ColorRGBA additionalColor;
   private ColorRGBA outlineColor;
   private ColorRGBA flatColor;
   private ColorRGBA accentColor;
   private ColorRGBA iconsColor;
   private ColorRGBA enabledModulesColor;

   public CustomThemeImpl(String name, CustomTheme source) {
      this.name = name;
      this.dark = source.isDark();
      this.defaultTextColor = source.getTextColor();
      this.defaultBackgroundColor = source.getBackgroundColor();
      this.defaultAdditionalColor = source.getAdditionalColor();
      this.defaultOutlineColor = source.getOutlineColor();
      this.defaultFlatColor = source.getFlatColor();
      this.defaultAccentColor = source.getAccentColor();
      this.defaultIconsColor = source.getIconsColor();
      this.defaultEnabledModulesColor = source.getEnabledModulesColor();
      this.textColor = source.getTextColor();
      this.backgroundColor = source.getBackgroundColor();
      this.additionalColor = source.getAdditionalColor();
      this.outlineColor = source.getOutlineColor();
      this.flatColor = source.getFlatColor();
      this.accentColor = source.getAccentColor();
      this.iconsColor = source.getIconsColor();
      this.enabledModulesColor = source.getEnabledModulesColor();
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public boolean isDark() {
      return this.dark;
   }

   @Override
   public ColorRGBA getTextColor() {
      return this.textColor;
   }

   @Override
   public void setTextColor(ColorRGBA color) {
      this.textColor = color;
   }

   @Override
   public ColorRGBA getBackgroundColor() {
      return this.backgroundColor;
   }

   @Override
   public void setBackgroundColor(ColorRGBA color) {
      this.backgroundColor = color;
   }

   @Override
   public ColorRGBA getAdditionalColor() {
      return this.additionalColor;
   }

   @Override
   public void setAdditionalColor(ColorRGBA color) {
      this.additionalColor = color;
   }

   @Override
   public ColorRGBA getOutlineColor() {
      return this.outlineColor;
   }

   @Override
   public void setOutlineColor(ColorRGBA color) {
      this.outlineColor = color;
   }

   @Override
   public ColorRGBA getFlatColor() {
      return this.flatColor;
   }

   @Override
   public void setFlatColor(ColorRGBA color) {
      this.flatColor = color;
   }

   @Override
   public ColorRGBA getAccentColor() {
      return this.accentColor;
   }

   @Override
   public void setAccentColor(ColorRGBA color) {
      this.accentColor = color;
   }

   @Override
   public ColorRGBA getIconsColor() {
      return this.iconsColor;
   }

   @Override
   public void setIconsColor(ColorRGBA color) {
      this.iconsColor = color;
   }

   @Override
   public ColorRGBA getEnabledModulesColor() {
      return this.enabledModulesColor;
   }

   @Override
   public void setEnabledModulesColor(ColorRGBA color) {
      this.enabledModulesColor = color;
   }

   @Override
   public void resetToDefault() {
      this.textColor = this.defaultTextColor;
      this.backgroundColor = this.defaultBackgroundColor;
      this.additionalColor = this.defaultAdditionalColor;
      this.outlineColor = this.defaultOutlineColor;
      this.flatColor = this.defaultFlatColor;
      this.accentColor = this.defaultAccentColor;
      this.iconsColor = this.defaultIconsColor;
      this.enabledModulesColor = this.defaultEnabledModulesColor;
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
}
