package moscow.rockstar.systems.commands.commands;

import moscow.rockstar.systems.commands.Command;
import moscow.rockstar.systems.commands.CommandBuilder;

public class IRCCommand {
   public Command command() {
      return CommandBuilder.begin("irc", b -> b.desc("Коммуникации между пользователями").handler(ctx -> {})).build();
   }
}
