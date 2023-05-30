package de.okayserver;

import de.okayserver.SQL.Tables.Mines.mines;
import de.okayserver.Users.User;

import java.text.DecimalFormat;

public class CoalMine {

    public static double CashPerSecond(User u) {

        double PrestigeMultiplier = 1;

        double Miner = MinerPerSecond(u);
        double Shop = ShopPerSecond(u);
        double Elevator = ElevatorPerSecond(u);


        if (Shop <= Miner) {
            Miner = Shop;
        }

        if (Elevator <= Miner) {
            Miner = Elevator;
        }

        return Miner;
    }
    public static double MinerPerSecond(User u) {
        double defaultAmount = 0.5;

        double perSecond = 0;



        int x = 1;
        while (x != 25) {

            double level = mines.getInfo(u , "Coal" , "MINER" + x);
            if (level >= 1) {

                double multiplier = (level / 10 ) + 1;
                perSecond= defaultAmount * multiplier +perSecond;

                defaultAmount = defaultAmount * 3;
                x++;
            } else {
                break;
            }
        }
        return perSecond;
    }
    public static double ShopPerSecond(User u) {
        int ShopLevel = mines.getInfo(u , "Coal", "SHOP");

        double ShopMax = 2;
        int x = 1;
        while ( x != ShopLevel ) {
            ShopMax = ShopMax * 1.1236;
            x++;
        }
        return ShopMax;
    }

    public static double ElevatorPerSecond(User u) {
        int ElevLevel = mines.getInfo(u , "Coal", "SHOP");


        double ElevMax = 2;
        int x = 1;
        while ( x != ElevLevel ) {
            ElevMax = ElevMax * 1.2113;
            x++;
        }
        return ElevMax;
    }

    public static void GenerateCash() {

        for (User u : User.UserList.values()) {
            double Cash = mines.getInfo(u , "Coal" , "CASH");
            Cash = Cash+ (5 * CashPerSecond(u));
            mines.updateCash(u , "Coal" , Cash );
        }
    }
}
