import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
//import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class MyBot extends ListenerAdapter //Simplifies the creation of event listeners for Discord bot events
{
    public static void main(String[] args) throws Exception {
        String bot_token = "MTE1MzQ4Mjg3MDk4MDA4Mzc2Mw.GUdLsQ.YC-Gxq8guzSsnPoMiO6fvyKYu35fu_uzNwzdfk";
        JDABuilder.createDefault(bot_token) //creates a new JDABuilder instance and sets it up with your bot's token stored in bot_token.
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT) // Enable the intents
                .addEventListeners(new MyBot())  //adds an instance of the MyBot class as an event listener for the bot.
                .setActivity(Activity.playing("Hello, World!")) //Sets the bot's activity to "Playing Hello, World!"
                                                                      // This activity will be displayed next to the bot's name in Discord.
                .build(); //Finalizes the setup and starts the bot, making it connect to Discord and listen for events.

    }

//    @Override
//    public void onReady(ReadyEvent event) {   //an event handler that is called when the bot is ready to operate.
//                                              // It takes a ReadyEvent as a parameter, which contains information about the bot's readiness.
//        System.out.println("Logged in as " + event.getJDA().getSelfUser().getName()); //It prints a message to the console indicating that the bot has logged in and mentions the bot's username.
//    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {  //Another event handler. It is called whenever a message is received in a channel where the bot has access.
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!Hey bot")) { //Checks if the content of the received message. is equal to "!hey bot".
            event.getChannel().sendMessage("Hey there! How you are doing?").queue();  // If it is, the bot responds back to the same channel where the message was received

        }
    }


}
