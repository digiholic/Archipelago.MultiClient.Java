package dev.koifysh.archipelago.network.server;

import com.google.gson.annotations.SerializedName;
import dev.koifysh.archipelago.network.APPacket;
import dev.koifysh.archipelago.network.APPacketType;
import dev.koifysh.archipelago.network.RemainingMode;
import dev.koifysh.archipelago.parts.NetworkPlayer;
import dev.koifysh.archipelago.parts.Version;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomInfoPacket extends APPacket {

    public Version version;

    public String[] tags;

    public boolean password;

    @SerializedName("forfeit_mode")
    public RemainingMode.ForfeitMode forfeitMode;

    @SerializedName("remaining_mode")
    public RemainingMode remainingMode;

    @SerializedName("hint_cost")
    public int hintCost;

    @SerializedName("location_check_points")
    public int locationCheckPoints;

    @SerializedName("players")
    public ArrayList<NetworkPlayer> networkPlayers = new ArrayList<>();

    @SerializedName("games")
    public ArrayList<String> games = new ArrayList<>();
    @SerializedName("datapackage_versions")
    public HashMap<String, Integer> datapackageVersions = new HashMap<>();

    @SerializedName("seed_name")
    public String seedName;

    @SerializedName("time")
    public double time;

    @SerializedName("permissions")
    public HashMap<String, Integer> permissions;

    public RoomInfoPacket() {
        super(APPacketType.RoomInfo);
    }

    public NetworkPlayer getPlayer(int team, int slot) {
        for(NetworkPlayer player : networkPlayers) {
            if (player.slot == slot && player.team == team) {
                return player;
            }
        }
        return null;
    }
}
