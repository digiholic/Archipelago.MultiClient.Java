package dev.koifysh.archipelago.network.client;

import dev.koifysh.archipelago.network.APPacket;
import dev.koifysh.archipelago.network.APPacketType;

import java.util.Set;

public class GetDataPackagePacket extends APPacket {

    Set<String> exclusions;

    public GetDataPackagePacket() {
        this(null);
    }

    public GetDataPackagePacket(Set<String> exclusions) {
        super(APPacketType.GetDataPackage);
        this.exclusions = exclusions;
    }
}
