package de.okayserver;

import de.okayserver.SQL.Tables.Mines.mines;
import de.okayserver.Users.User;

public class CoalMine {

    public static double CashPerSecond(User u) {

        double PrestigeMultiplier = 1;

        double defaultAmount = 0.5;

        double perSecond = 0;

        for (int x = 1 ; x== 25 ; x++) {
            double level = mines.getInfo(u , "Coal" , "Miner" + x);
            if (level >= 1) {
                double multiplier = level / 10 + 1;
                perSecond= defaultAmount * multiplier +perSecond;

                defaultAmount = defaultAmount * 3;
            } else {
                break;
            }
        }

        return perSecond;
    }


    public static void GenerateCash() {

        for (User u : User.UserList.values()) {
            double Cash = mines.getInfo(u , "Coal" , "CASH");
            Cash = Cash+ (5* CashPerSecond(u));
            mines.updateCash(u , "Coal" , Cash );
        }
    }
}
