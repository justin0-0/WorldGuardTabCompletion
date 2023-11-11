package de.justin.worldguardtabcompletion;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class Listner implements Listener {
    public static HashMap<Player, ArrayList<String>> tab = new HashMap<>();

    @EventHandler
    public void onEvent(TabCompleteEvent event) {
        if (!(event.getSender() instanceof Player)) {
            return;
        }

        String buffer = event.getBuffer();
        if (!getS(buffer, 0).equals("rg") && !getS(event.getBuffer(), 0).equals("region") && !getS(event.getBuffer(), 0).equals("regions")) {
            return;
        }

        Player player = (Player) event.getSender();
        if (!isNewArg(event.getBuffer())) {
            if (tab.containsKey(player)) {
                event.setCompletions(tab.get(player));
            }
            return;
        }

        ArrayList<String> list = new ArrayList<>();

        //First subCommand
        if (lenght(buffer) == 2) {
            list.add("create");
            list.add("define");
            list.add("d");
            list.add("remove");
            list.add("rem");
            list.add("delete");
            list.add("del");
            list.add("redefine");
            list.add("update");
            list.add("move");
            list.add("claim");
            list.add("addmember");
            list.add("addmem");
            list.add("am");
            list.add("addowner");
            list.add("ao");
            list.add("removemember");
            list.add("remmember");
            list.add("remmem");
            list.add("rm");
            list.add("removeowner");
            list.add("ro");
            list.add("select");
            list.add("sel");
            list.add("s");
            list.add("info");
            list.add("i");
            list.add("flags");
            list.add("list");
            list.add("flag");
            list.add("setpriority");
            list.add("priority");
            list.add("pri");
            list.add("setparent");
            list.add("parent");
            list.add("par");
            list.add("teleport");
            event.setCompletions(list);
            if (tab.containsKey(player)) {
                tab.replace(player, list);
            }else {
                tab.put(player, list);
            }
            return;
        }

        //Second Subcommand
        if (compare(buffer, 1, "create", "define", "d")) {
            ArrayList<String> list1 = getListCreate(buffer);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
            return;
        }
        if (compare(buffer, 1, "remove", "rem", "delete", "del")) {
            ArrayList<String> list1 = getListRemove(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "redefine", "update", "move")) {
            ArrayList<String> list1 = getListRedefine(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "claim")) {
            ArrayList<String> list1 = getListClaim(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "addmember", "addmem", "am")) {
            ArrayList<String> list1 = getListAddMemOwn(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "addowner", "ao")) {
            ArrayList<String> list1 = getListAddMemOwn(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "removemember", "remmember", "remmem", "rm")) {
            ArrayList<String> list1 = getListRemoveMemOwn(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "removeowner", "ro")) {
            ArrayList<String> list1 = getListRemoveMemOwn(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "select", "sel", "s")) {
            ArrayList<String> list1 = getListSelect(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "info", "i")) {
            ArrayList<String> list1 = getListInfo(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "flags")) {
            ArrayList<String> list1 = getListFlags(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "list")) {
            ArrayList<String> list1 = getListList(buffer);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "flag")) {
            ArrayList<String> list1 = getListFlag(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "setpriority", "priority", "pri")) {
            ArrayList<String> list1 = getListPriority(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "setparent", "parent", "par")) {
            ArrayList<String> list1 = getListParrent(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
        if (compare(buffer, 1, "teleport")) {
            ArrayList<String> list1 = getListTeleport(buffer, player);
            if (tab.containsKey(player)) {
                tab.replace(player, list1);
            }else {
                tab.put(player, list1);
            }
            event.setCompletions(list1);
        }
    }

    //Get Command and Subcommand from Buffer
    public String getS(String buffer, int subCommand) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split(" ");
        return s3[subCommand];
    }
    public boolean compare(String buffer, int subCommand, String... strings){
        String string = getS(buffer, subCommand);
        for (String s : strings) {
            if (s.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }
    public int lenght(String buffer) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        return s3.length;
    }
    public boolean isUsedBefore(String buffer, String string) {
        if (lenght(buffer) >= 2) {
            return getS(buffer, lenght(buffer) - 2).equals(string);
        }
        return false;
    }
    public boolean isUsed(String buffer, String string) {
        return buffer.contains(string);
    }
    public boolean hasSpecifiedRegionID(String buffer, String... strings) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        String[] s4 = ArrayUtils.remove(s3, 0);
        String[] s5 = ArrayUtils.remove(s4, 0);
        String[] s6 = ArrayUtils.remove(s5, s5.length-1);
        int i = 0;
        for (String s : s6) {
            int a = i - 1;
            if (i >= 1) {
                if (!s.equals(" -w") && !s6[a].equals(" -w") && !s.equals(" ") && !isOneOfTheseArgs(s, strings) && !s6[a].equals(" -p") && !s6[a].equals(" -i") && !s.equals(" -p") && !s.equals(" -i")) {
                    return true;
                }
            }else {
                if (!s.equals(" -w") && !s.equals(" ") && !s.equals(" -p") && !s.equals(" -i") && !isOneOfTheseArgs(s, strings)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    public boolean isOneOfTheseArgs(String string1, String... strings) {
        for (String string : strings) {
            if (string1.equals(string)) {
                return true;
            }
        }
        return false;
    }
    public boolean isNewArg(String buffer) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        return s3[s3.length-1].equals(" ");
    }

    public static boolean hasSpecifiedWorld(String buffer) {
        if (buffer.contains("-w")) {
            String s2 = buffer.replace("/", "");
            String[] s3 = s2.split(" ");
            int i = 0;
            for (String s : s3) {
                if (s.equals("-w")) {
                    if (s3.length >= i + 1) {
                        return true;
                    }else {
                        return false;
                    }
                }
                i++;
            }
        }
        return false;
    }

    public World getSpecifiedWorld(String buffer) {
        if (buffer.contains("-w")) {
            String s2 = buffer.replace("/", "");
            String[] s3 = s2.split(" ");
            int i = 0;
            for (String s : s3) {
                if (s.equals("-w")) {
                    if (s3.length >= i + 1) {
                        return Bukkit.getWorld(s3[i + 1]);
                    }else {
                        return null;
                    }
                }
                i++;
            }
        }
        return null;
    }
    public ArrayList<String> getRegions(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (hasSpecifiedWorld(buffer)) {
            if (getSpecifiedWorld(buffer) != null) {
                World world = getSpecifiedWorld(buffer);
                WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(world)).getRegions().forEach((s, protectedRegion) -> list.add(protectedRegion.getId()));
                return list;
            }
        }
        WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(player.getWorld())).getRegions().forEach((s, protectedRegion) -> list.add(protectedRegion.getId()));
        return list;
    }
    //Create
    public ArrayList<String> getListCreate(String buffer) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-g")) {
            list.add("-g");
        }
        if (hasSpecifiedRegionID(buffer, " -g")) {
            for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
                list.add(offlinePlayer.getName());
            }
        }else {
            list.add("[RegionID]");
        }
        return list;
    }


    //Remove
    public ArrayList<String> getListRemove(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-u") && !isUsed(buffer, "-f")) {
            list.add("-u");
        }
        if (!isUsed(buffer, "-f") && !isUsed(buffer, "-u")) {
            list.add("-f");
        }
        if (!hasSpecifiedRegionID(buffer, " -u", " -f")) {
            list.addAll(getRegions(buffer, player));
        }
        return list;
    }

    public ArrayList<String> getListRedefine(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-g")) {
            list.add("-g");
        }
        if (!hasSpecifiedRegionID(buffer, " -g")) {
            list.addAll(getRegions(buffer, player));
            list.remove("__global__");
        }
        return list;
    }

    public ArrayList<String> getListClaim(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
            list.remove("__global__");
        }
        return list;
    }

    public ArrayList<String> getListAddMemOwn(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }else {
            for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
                list.add(offlinePlayer.getName());
            }
        }
        return list;
    }

    public ArrayList<String> getListRemoveMemOwn(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-a")) {
            list.add("-a");
        }
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }else if (!isUsed(buffer, "-a") && hasSpecifiedRegionID(buffer)){
            for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
                list.add(offlinePlayer.getName());
            }
        }
        return list;
    }

    public ArrayList<String> getListSelect(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }
        return list;
    }

    public ArrayList<String> getListInfo(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-u")) {
            list.add("-u");
        }
        if (!isUsed(buffer, "-s")) {
            list.add("-s");
        }
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }

        return list;
    }

    public ArrayList<String> getListFlags(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (isUsedBefore(buffer, "-p")) {
            list.add("[Page]");
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-p")) {
            list.add("-p");
        }
        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }

        return list;
    }

    public ArrayList<String> getListList(String buffer) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (isUsedBefore(buffer, "-p")) {
            for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
                list.add(offlinePlayer.getName());
            }
            return list;
        }
        if (isUsedBefore(buffer, "-i")) {
            list.add("[ID Search]");
            return list;
        }

        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-p")) {
            list.add("-p");
        }
        if (!isUsed(buffer, "-i")) {
            list.add("-i");
        }


        if (!hasSpecifiedRegionID(buffer)) {
            list.add("[Page]");
        }

        return list;
    }

    public boolean hasSpecifiedRegionIDFlagNothing(String buffer, String... strings) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        String[] s4 = ArrayUtils.remove(s3, 0);
        String[] s5 = ArrayUtils.remove(s4, 0);
        String[] s6 = ArrayUtils.remove(s5, s5.length-1);
        int i = 0;
        int e = 0;
        for (String s : s6) {
            int a = i - 1;
            if (i >= 1) {
                if (!s.equals(" -w") && !s6[a].equals(" -w") && !s.equals(" ") && !isOneOfTheseArgs(s, strings) && !s6[a].equals(" -g") && !s.equals(" -g")) {
                    e++;
                }
            }else {
                if (!s.equals(" -w") && !s.equals(" -g") && !s.equals(" ") && !isOneOfTheseArgs(s, strings)) {
                    e++;
                }
            }
            i++;
        }
        if (e == 0) {
            return true;
        }
        return false;
    }
    public boolean hasSpecifiedRegionFlagFlag(String buffer, String... strings) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        String[] s4 = ArrayUtils.remove(s3, 0);
        String[] s5 = ArrayUtils.remove(s4, 0);
        String[] s6 = ArrayUtils.remove(s5, s5.length-1);
        int i = 0;
        int e = 0;
        for (String s : s6) {
            int a = i - 1;
            if (i >= 1) {
                if (!s.equals(" -w") && !s6[a].equals(" -w") && !s.equals(" ") && !isOneOfTheseArgs(s, strings) && !s6[a].equals(" -g") && !s.equals(" -g")) {
                    e++;
                }
            }else {
                if (!s.equals(" -w") && !s.equals(" -g") && !s.equals(" ") && !isOneOfTheseArgs(s, strings)) {
                    e++;
                }
            }
            i++;
        }
        if (e == 1) {
            return true;
        }
        return false;
    }
    public boolean hasSpecifiedRegionValueFlag(String buffer, String... strings) {
        String s2 = buffer.replace("/", "");
        String[] s3 = s2.split("(?= )");
        String[] s4 = ArrayUtils.remove(s3, 0);
        String[] s5 = ArrayUtils.remove(s4, 0);
        String[] s6 = ArrayUtils.remove(s5, s5.length-1);
        int i = 0;
        int e = 0;
        for (String s : s6) {
            int a = i - 1;
            if (i >= 1) {
                if (!s.equals(" -w") && !s6[a].equals(" -w") && !s.equals(" ") && !isOneOfTheseArgs(s, strings) && !s6[a].equals(" -g") && !s.equals(" -g")) {
                    e++;
                }
            }else {
                if (!s.equals(" -w") && !s.equals(" -g") && !s.equals(" ") && !isOneOfTheseArgs(s, strings)) {
                    e++;
                }
            }
            i++;
        }
        if (e == 2) {
            return true;
        }
        return false;
    }
    public ArrayList<String> getListFlag(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }
        if (isUsedBefore(buffer, "-g")) {
            list.add("all");
            list.add("members");
            list.add("owners");
            list.add("nonmembers");
            list.add("nonowners");
            return list;
        }
        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-g")) {
            list.add("-g");
        }
        if (!isUsed(buffer, "-e")) {
            list.add("-e");
        }


        if (hasSpecifiedRegionIDFlagNothing(buffer, " -e")) {
            list.addAll(getRegions(buffer, player));
        }
        if (hasSpecifiedRegionFlagFlag(buffer, " -e")) {
            WorldGuard.getInstance().getFlagRegistry().forEach(flag -> list.add(flag.getName()));
        }
        if (hasSpecifiedRegionValueFlag(buffer, " -e")) {
            list.add("allow");
            list.add("deny");
            list.add("[Value]");
        }
        return list;
    }

    public ArrayList<String> getListPriority(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }

        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }


        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }else {
            list.add("[Priority]");
        }

        return list;
    }

    public ArrayList<String> getListParrent(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }

        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }

        if (!hasSpecifiedRegionID(buffer)) {
            list.addAll(getRegions(buffer, player));
        }else {
            list.addAll(getRegions(buffer, player));
        }

        return list;
    }

    public ArrayList<String> getListTeleport(String buffer, Player player) {
        ArrayList<String> list = new ArrayList<>();
        if (isUsedBefore(buffer, "-w")) {
            Bukkit.getWorlds().forEach(world -> list.add(world.getName()));
            return list;
        }

        if (!isUsed(buffer, "-w")) {
            list.add("-w");
        }
        if (!isUsed(buffer, "-c")) {
            list.add("-c");
        }
        if (!isUsed(buffer, "-s")) {
            list.add("-s");
        }

        if (!hasSpecifiedRegionID(buffer, " -c", " -s")) {
            list.addAll(getRegions(buffer, player));
        }

        return list;
    }
}
