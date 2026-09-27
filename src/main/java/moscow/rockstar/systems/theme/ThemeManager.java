package moscow.rockstar.systems.theme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import moscow.rockstar.Rockstar;
import moscow.rockstar.utility.colors.ColorRGBA;

public class ThemeManager {
   private CustomTheme currentTheme = Theme.DARK;
   private final List<CustomTheme> customThemes = new ArrayList<>();

   public void switchTheme() {
      this.currentTheme = this.currentTheme.isDark() ? Theme.LIGHT : Theme.DARK;
   }

   public CustomTheme getCurrentTheme() {
      return this.currentTheme;
   }

   public List<CustomTheme> getThemes() {
      List<CustomTheme> themes = new ArrayList<>(Arrays.asList(Theme.values()));
      themes.addAll(this.customThemes);
      return themes;
   }

   public List<CustomTheme> getCustomThemes() {
      return this.customThemes;
   }

   public void clearCustomThemes() {
      this.customThemes.clear();
   }

   public CustomTheme addTheme(String name) {
      CustomThemeImpl theme = new CustomThemeImpl(name, this.currentTheme);
      this.customThemes.add(theme);
      return theme;
   }

   public CustomTheme findTheme(String name) {
      for (CustomTheme theme : this.getThemes()) {
         if (theme.getName().equals(name)) {
            return theme;
         }
      }
      return null;
   }

   public ColorRGBA getTextColor() {
      return this.getCurrentTheme().getTextColor();
   }

   public ColorRGBA getBackgroundColor() {
      return this.getCurrentTheme().getBackgroundColor();
   }

   public ColorRGBA getAdditionalColor() {
      return this.getCurrentTheme().getAdditionalColor();
   }

   public ColorRGBA getOutlineColor() {
      return this.getCurrentTheme().getOutlineColor();
   }

   public ColorRGBA getFlatColor() {
      return this.getCurrentTheme().getFlatColor();
   }

   public ColorRGBA getAccentColor() {
      return this.getCurrentTheme().getAccentColor();
   }

   public ColorRGBA getIconsColor() {
      return this.getCurrentTheme().getIconsColor();
   }

   public ColorRGBA getEnabledModulesColor() {
      return this.getCurrentTheme().getEnabledModulesColor();
   }

   public void setTextColor(ColorRGBA color) {
      this.getCurrentTheme().setTextColor(color);
   }

   public void setBackgroundColor(ColorRGBA color) {
      this.getCurrentTheme().setBackgroundColor(color);
   }

   public void setAdditionalColor(ColorRGBA color) {
      this.getCurrentTheme().setAdditionalColor(color);
   }

   public void setAccentColor(ColorRGBA color) {
      this.getCurrentTheme().setAccentColor(color);
   }

   public void flushSave() {
      try {
         Rockstar.getInstance().getFileManager().writeFile("client");
      } catch (Exception var2) {
      }
   }

   public void setCurrentTheme(CustomTheme currentTheme) {
      this.currentTheme = currentTheme;
   }

   public void resetToDefault() {
      this.getCurrentTheme().resetToDefault();
      this.flushSave();
   }

   public void deleteTheme(CustomTheme theme) {
      if (this.customThemes.remove(theme)) {
         if (this.currentTheme == theme) {
            this.currentTheme = Theme.DARK;
         }

         this.flushSave();
      }
   }
}
