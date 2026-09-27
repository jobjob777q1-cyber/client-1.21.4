package moscow.rockstar.systems.theme;

import moscow.rockstar.utility.colors.ColorRGBA;

public interface CustomTheme {
   String getName();

   ColorRGBA getTextColor();

   void setTextColor(ColorRGBA color);

   ColorRGBA getBackgroundColor();

   void setBackgroundColor(ColorRGBA color);

   ColorRGBA getAdditionalColor();

   void setAdditionalColor(ColorRGBA color);

   ColorRGBA getOutlineColor();

   void setOutlineColor(ColorRGBA color);

   ColorRGBA getFlatColor();

   void setFlatColor(ColorRGBA color);

   ColorRGBA getAccentColor();

   void setAccentColor(ColorRGBA color);

   ColorRGBA getIconsColor();

   void setIconsColor(ColorRGBA color);

   ColorRGBA getEnabledModulesColor();

   void setEnabledModulesColor(ColorRGBA color);

   boolean isDark();

   void resetToDefault();

   boolean isSeparators();

   float getBlurStrength();

   float getGlassOpacity();

   float getMinimalismOpacity();

   float getEnabledOffset();

   float getHudRounding();

   float getBlurOffset();

   float getHudAlpha();

   float getDisableAlphaGlass();

   float getGlassPower();

   float getGlassStrength();

   float getPadding();

   float getSplitters();

   float getAlbumColor();
}
