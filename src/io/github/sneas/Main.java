package io.github.sneas;

import java.util.*;

public class Main {

    static class TotalItem {
        int sum;
        int immediate;

        TotalItem(int sum, int immediate) {
            this.sum = sum;
            this.immediate = immediate;
        }
    }

    static int solve(int[][] shots, int[][] players) {
        Arrays.sort(shots, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int first = a[0] - b[0];
                if (first == 0) {
                    return a[1] - b[1];
                }

                return first;
            }
        });

        int maxLength = 0;

        for (int[] shot : shots) {
            if (shot[1] > maxLength) {
                maxLength = shot[1];
            }
        }

        TotalItem[] totalItems = new TotalItem[maxLength];
        int shotIndex = 0;
        int sum = 0;
        int immediate = 0;

        for (int i = 0; i < totalItems.length; i++) {
            int end = totalItems[i] != null ? totalItems[i].immediate : 0;

            while (shotIndex < shots.length &&  i == shots[shotIndex][0] - 1) {
                sum++;
                immediate++;
                TotalItem endItem = totalItems[shots[shotIndex][1] - 1] != null ? totalItems[shots[shotIndex][1] - 1] : new TotalItem(0, 0);
                endItem.immediate -= 1;
                totalItems[shots[shotIndex][1] - 1] = endItem;
                shotIndex++;
            }

            totalItems[i] = new TotalItem(sum, immediate);

            immediate += end;
        }

        int result = 0;

        for (int[] player : players) {
            TotalItem startItem = totalItems[player[0] - 1];
            int end = Math.min(player[1], totalItems.length);
            result += totalItems[end - 1].sum - (startItem.sum - startItem.immediate);
        }

        return result;
    }

    public static void main(String[] args) {
        long result  = solve(new int[][]{
                {546, 1434},
                {763, 1609},
                {244, 266},
                {17, 953},
                {279, 496},
                {467, 864},
                {784, 789},
                {161, 858},
                {285, 1055},
                {991, 1794},
                {735, 1699},
                {597, 1546},
                {439, 555},
                {835, 1620},
                {631, 1598},
                {608, 1588},
                {66, 88},
                {165, 1149},
                {310, 1092},
                {637, 1265},
                {89, 105},
                {952, 1542},
                {386, 494},
                {265, 749},
                {113, 330},
                {572, 619},
                {418, 1178},
                {443, 789},
                {534, 1016},
                {899, 1301},
                {787, 1186},
                {603, 984},
                {957, 990},
                {261, 317},
                {220, 820},
                {608, 1380},
                {120, 311},
                {29, 485},
                {322, 329},
                {360, 661},
                {437, 1400},
                {298, 336},
                {61, 192},
                {877, 1763},
                {791, 827},
                {831, 1022},
                {489, 881},
                {314, 514},
                {659, 918},
                {699, 1242},
                {958, 1908},
                {10, 633},
                {564, 1083},
                {489, 604},
                {961, 1825},
                {233, 453},
                {696, 1646},
                {993, 1648},
                {537, 582},
                {345, 764},
                {249, 796},
                {982, 1343},
                {610, 1596},
                {46, 66},
                {309, 327},
                {783, 883},
                {821, 1188},
                {426, 1352},
                {846, 1372},
                {942, 1268},
                {446, 579},
                {403, 507},
                {954, 1062},
                {371, 397},
                {564, 939},
                {32, 918},
                {876, 1641},
                {522, 745},
                {101, 691},
                {535, 1521},
                {202, 514},
                {96, 816},
                {648, 1634},
                {106, 322},
                {13, 970},
                {186, 676},
                {1, 873},
                {125, 734},
                {740, 783},
                {727, 808},
                {641, 1160},
                {321, 507},
                {105, 765},
                {809, 843},
                {691, 1597},
                {557, 1519},
                {98, 222},
                {183, 521},
                {127, 136},
                {640, 1231},
                {577, 1046},
                {302, 484},
                {395, 899},
                {160, 809},
                {277, 394},
                {780, 1773},
                {573, 587},
                {406, 1178},
                {759, 869},
                {484, 638},
                {418, 1193},
                {623, 1298},
                {382, 1035},
                {405, 704},
                {187, 422},
                {517, 613},
                {211, 447},
                {330, 413},
                {939, 1152},
                {4, 393},
                {413, 1246},
                {299, 808},
                {482, 638},
                {445, 572},
                {358, 643},
                {378, 1264},
                {868, 1434},
                {983, 1252},
                {900, 1681},
                {240, 291},
                {371, 435},
                {801, 910},
                {514, 862},
                {590, 1406},
                {489, 576},
                {425, 985},
                {229, 1212},
                {244, 790},
                {263, 945},
                {800, 1785},
                {351, 846},
                {909, 1548},
                {473, 486},
                {851, 1604},
                {199, 338},
                {56, 1041},
                {231, 1191},
                {755, 1017},
                {318, 962},
                {593, 1471},
                {517, 795},
                {390, 765},
                {964, 1235},
                {623, 826},
                {428, 746},
                {405, 511},
                {113, 919},
                {611, 1607},
                {671, 1125},
                {484, 1107},
                {980, 1019},
                {575, 940},
                {399, 1154},
                {613, 823},
                {544, 1419},
                {669, 842},
                {968, 1738},
                {140, 985},
                {18, 635},
                {99, 777},
                {730, 1660},
                {860, 1671},
                {484, 1213},
                {374, 556},
                {216, 735},
                {337, 1199},
                {877, 886},
                {867, 1732},
                {52, 861},
                {645, 1279},
                {111, 658},
                {32, 276},
                {633, 1012},
                {116, 884},
                {23, 948},
                {457, 804},
                {768, 1213},
                {807, 1715},
                {161, 1153},
                {740, 1336},
                {172, 1150},
                {140, 923},
                {449, 1242},
                {894, 920},
                {445, 1063},
                {860, 1098},
                {331, 710},
                {19, 63},
                {385, 906},
                {564, 1228},
                {4, 15},
                {834, 1061},
                {918, 1308},
                {852, 1312},
                {839, 842},
                {838, 1045},
                {681, 1575},
                {587, 1540},
                {953, 1304},
                {502, 609},
                {843, 1353},
                {466, 1215},
                {748, 1519},
                {549, 1481},
                {334, 1010},
                {396, 779},
                {144, 1123},
                {483, 1457},
                {868, 1763},
                {341, 969},
                {606, 1295},
                {683, 914},
                {665, 827},
                {648, 845},
                {35, 895},
                {356, 1286},
                {124, 1002},
                {710, 1629},
                {763, 1102},
                {736, 1109},
                {210, 671},
                {102, 128},
                {92, 401},
                {783, 1434},
                {387, 538},
                {656, 1411},
                {246, 370},
                {877, 1864},
                {587, 635},
                {489, 1388},
                {577, 751},
                {543, 1342},
                {642, 1354},
                {810, 1567},
                {775, 1458},
                {970, 1512},
                {517, 767},
                {600, 788},
                {422, 1192},
                {461, 960},
                {251, 665},
                {614, 1128},
                {704, 836},
                {674, 1574},
                {992, 1639},
                {318, 480},
                {851, 985},
                {201, 788},
                {901, 1738},
                {484, 547},
                {809, 892},
                {301, 1021},
                {302, 626},
                {316, 870},
                {640, 912},
                {900, 1225},
                {82, 158},
                {70, 671},
                {619, 1138},
                {683, 1324},
                {199, 550},
                {545, 963},
                {824, 1621},
                {656, 1534},
                {107, 1017},
                {421, 849},
                {584, 1387},
                {663, 1490},
                {693, 953},
                {176, 943},
                {410, 891},
                {301, 487},
                {282, 1107},
                {82, 281},
                {328, 798},
                {864, 1547},
                {376, 832},
                {848, 1437},
                {624, 1057},
                {53, 412},
                {622, 1039},
                {349, 514},
                {284, 608},
                {344, 838},
                {362, 594},
                {613, 638},
                {858, 1133},
                {520, 994},
                {330, 1279},
                {976, 1796},
                {789, 1782},
                {65, 274},
                {235, 253},
                {645, 1029},
                {843, 1071},
                {424, 1087},
                {278, 494},
                {428, 1341},
                {717, 1289},
                {218, 1139},
                {525, 775},
                {490, 1042},
                {506, 722},
                {765, 1753},
                {483, 587},
                {49, 746},
                {732, 1436},
                {21, 297},
                {729, 1190},
                {318, 1092},
                {234, 886},
                {153, 678},
                {289, 515},
                {857, 1426},
                {924, 1848},
                {579, 833},
                {711, 1632},
                {249, 1078},
                {802, 1648},
                {132, 1068},
                {75, 781},
                {637, 1491},
                {205, 945},
                {518, 865},
                {961, 1306},
                {524, 808},
                {707, 1262},
                {511, 601},
                {577, 1239},
                {806, 1091},
                {336, 1077},
                {541, 815},
                {528, 676},
                {528, 1424},
                {192, 351},
                {532, 1467},
                {988, 1831},
                {508, 614},
                {22, 937},
                {762, 1521},
                {276, 499},
                {654, 1051},
                {641, 1480},
                {892, 1337},
                {982, 1396},
                {945, 1181},
                {81, 910},
                {102, 278},
                {590, 1331},
                {168, 912},
                {446, 808},
                {71, 776},
                {646, 778},
                {469, 995},
                {161, 960},
                {82, 642},
                {96, 645},
                {70, 525},
                {569, 1355},
                {502, 517},
                {46, 407},
                {683, 1073},
                {216, 430},
                {919, 1709},
                {595, 862},
                {353, 815},
                {867, 1745},
                {131, 1040},
                {551, 1338},
                {530, 740},
                {990, 1628},
                {389, 754},
                {623, 1467},
                {170, 924},
                {725, 1384},
                {974, 1374},
                {931, 986},
                {396, 905},
                {724, 1090},
                {927, 1515},
                {550, 748},
                {163, 556},
                {616, 1197},
                {289, 1141},
                {986, 1843},
                {969, 1478},
                {107, 237},
                {717, 1220},
                {673, 902},
                {555, 1474},
                {500, 974},
                {60, 899},
                {340, 916},
                {267, 569},
                {749, 1260},
                {24, 475},
                {776, 1310},
                {717, 1087},
                {84, 410},
                {936, 1413},
                {308, 1067},
                {571, 906},
                {738, 1460},
                {752, 925},
                {532, 650},
                {561, 1087},
                {215, 1142},
                {327, 1076},
                {754, 1358},
                {913, 1261},
                {436, 1220},
                {384, 1283},
                {600, 1243},
                {873, 1658},
                {519, 1168},
                {890, 1027},
                {422, 858},
                {552, 1409},
                {339, 1112},
                {1000, 1216},
                {874, 939},
                {332, 578},
                {653, 815},
                {1, 418},
                {499, 918},
                {455, 628},
                {16, 320},
                {144, 1003},
                {198, 923},
                {453, 506},
                {937, 1007},
                {13, 69},
                {777, 1512},
                {703, 970},
                {524, 689},
                {387, 1266},
                {611, 1296},
                {908, 1148},
                {222, 761},
                {656, 1428},
                {914, 1279},
                {283, 1148},
                {185, 826},
                {720, 1619},
                {290, 1102},
                {322, 400},
                {979, 1304},
                {594, 1227},
                {133, 167},
                {250, 1030},
                {71, 992},
                {890, 1709},
                {269, 926},
                {672, 1363},
                {330, 732},
                {757, 1674},
                {948, 1102},
                {990, 1759},
                {871, 1217},
                {952, 1717},
                {141, 910},
                {312, 405},
                {980, 1811},
                {737, 1414},
                {328, 404},
                {151, 788},
                {219, 804},
                {676, 1008},
                {618, 1417},
                {905, 1713},
                {242, 1017},
                {352, 1181},
                {27, 822},
                {439, 460},
                {91, 510},
                {31, 333},
                {94, 920},
                {222, 504},
                {205, 1191},
                {970, 1069},
                {212, 648},
                {175, 508},
                {601, 982},
                {963, 1316},
                {273, 495},
                {695, 1286},
                {453, 656},
                {145, 804},
                {958, 1620},
                {464, 708},
        }, new int[][]{
                {628, 936},
                {271, 808},
                {269, 1013},
                {358, 1282},
                {76, 483},
                {405, 1393},
                {480, 1468},
                {754, 911},
                {79, 1060},
                {621, 848},
                {395, 1033},
                {98, 161},
                {620, 1456},
                {655, 855},
                {325, 521},
                {167, 557},
                {355, 800},
                {566, 698},
                {99, 751},
                {62, 850},
                {251, 410},
                {505, 1344},
                {837, 1112},
                {360, 549},
                {376, 953},
                {643, 1348},
                {455, 1278},
                {674, 1642},
                {93, 744},
                {595, 711},
                {721, 1159},
                {621, 1522},
                {679, 1621},
                {469, 1396},
                {95, 139},
                {343, 1008},
                {778, 1530},
                {159, 716},
                {602, 1435},
                {200, 428},
                {977, 1715},
                {373, 553},
                {469, 1390},
                {950, 1098},
                {618, 619},
                {957, 1203},
                {889, 1147},
                {402, 872},
                {328, 760},
                {420, 519},
                {777, 1723},
                {17, 621},
                {864, 1315},
                {303, 684},
                {103, 205},
                {219, 389},
                {460, 778},
                {275, 1190},
                {997, 1905},
                {727, 887},
                {635, 1623},
                {157, 996},
                {277, 639},
                {590, 714},
                {566, 1255},
                {138, 906},
                {514, 1494},
                {99, 1080},
                {948, 1149},
                {529, 793},
                {980, 1566},
                {98, 962},
                {168, 254},
                {700, 819},
                {680, 1272},
                {773, 1132},
                {46, 980},
                {731, 977},
                {950, 1003},
                {464, 1069},
                {746, 988},
                {305, 534},
                {449, 1357},
                {879, 1002},
                {97, 258},
                {549, 579},
                {186, 272},
                {250, 1200},
                {533, 1328},
                {818, 1689},
                {701, 1546},
                {360, 1247},
                {917, 987},
                {799, 1563},
                {515, 1213},
                {345, 794},
                {683, 983},
                {415, 762},
                {806, 1055},
                {611, 1066},
                {604, 1310},
                {426, 1104},
                {984, 1056},
                {366, 761},
                {524, 1167},
                {219, 879},
                {789, 928},
                {264, 640},
                {703, 1618},
                {368, 929},
                {892, 1159},
                {522, 1507},
                {657, 1478},
                {621, 1086},
                {586, 1244},
                {56, 176},
                {159, 821},
                {345, 890},
                {415, 424},
                {869, 989},
                {428, 1243},
                {848, 1694},
                {982, 1529},
                {461, 480},
                {325, 460},
                {799, 1779},
                {9, 568},
                {17, 46},
                {341, 1020},
                {123, 619},
                {868, 1493},
                {478, 532},
                {914, 982},
                {378, 824},
                {365, 631},
                {382, 986},
                {533, 709},
                {464, 1196},
                {402, 1373},
                {734, 997},
                {398, 775},
                {340, 809},
                {643, 1617},
                {358, 1314},
                {334, 830},
                {313, 912},
                {276, 1209},
                {341, 560},
                {643, 1591},
                {413, 1179},
                {500, 773},
                {570, 922},
                {56, 861},
                {789, 1516},
                {177, 558},
                {532, 578},
                {930, 1203},
                {359, 780},
                {649, 1625},
                {579, 978},
                {932, 1278},
                {398, 1133},
                {746, 784},
                {916, 1513},
                {356, 362},
                {530, 1130},
                {28, 323},
                {833, 1189},
                {604, 1369},
                {821, 1003},
                {513, 856},
                {111, 276},
                {394, 761},
                {808, 1140},
                {356, 1217},
                {678, 691},
                {592, 1108},
                {244, 820},
                {991, 1611},
                {141, 337},
                {988, 1150},
                {857, 1774},
                {235, 896},
                {539, 1242},
                {249, 819},
                {986, 1540},
                {932, 959},
                {695, 1533},
                {652, 1607},
                {526, 935},
                {475, 768},
                {393, 872},
                {465, 1439},
                {65, 962},
                {802, 833},
                {526, 575},
                {100, 420},
                {409, 734},
                {955, 1789},
                {560, 1226},
                {224, 1171},
                {290, 764},
                {498, 1161},
                {243, 620},
                {35, 584},
                {474, 903},
                {726, 958},
                {498, 1230},
                {399, 838},
                {662, 849},
                {284, 1204},
                {248, 692},
                {18, 850},
                {859, 1466},
                {332, 673},
                {503, 1347},
                {687, 759},
                {398, 613},
                {585, 670},
                {221, 571},
                {796, 1369},
                {732, 1611},
                {909, 1683},
                {969, 1238},
                {634, 715},
                {26, 527},
                {852, 1153},
                {523, 983},
                {928, 1426},
                {695, 1346},
                {52, 828},
                {249, 879},
                {265, 834},
                {21, 478},
                {115, 303},
                {59, 638},
                {585, 788},
                {500, 620},
                {369, 913},
                {288, 1130},
                {875, 1622},
                {431, 807},
                {162, 881},
                {70, 272},
                {710, 1044},
                {293, 584},
                {117, 215},
                {646, 781},
                {203, 785},
                {833, 1816},
                {551, 787},
                {230, 681},
                {513, 577},
                {562, 1482},
                {761, 1061},
                {670, 1128},
                {217, 1022},
                {571, 1486},
                {254, 876},
                {43, 608},
                {939, 1512},
                {380, 608},
                {70, 401},
                {278, 542},
                {983, 1382},
                {784, 842},
                {206, 531},
                {638, 1474},
                {620, 1382},
                {125, 811},
                {517, 616},
                {834, 1752},
                {221, 756},
                {496, 663},
                {945, 1700},
                {632, 1030},
                {119, 548},
                {342, 687},
                {536, 867},
                {465, 1177},
                {708, 1000},
                {251, 764},
                {399, 1246},
                {458, 1089},
                {875, 1693},
                {447, 913},
                {918, 1052},
                {469, 514},
                {606, 1040},
                {372, 728},
                {826, 1286},
                {766, 1178},
                {682, 713},
                {145, 769},
                {146, 468},
                {567, 999},
                {482, 767},
                {194, 1087},
                {530, 860},
                {140, 431},
                {405, 910},
                {206, 691},
                {19, 374},
                {535, 1223},
                {788, 1536},
                {487, 528},
                {569, 948},
                {109, 381},
                {221, 713},
                {878, 1103},
                {148, 740},
                {375, 543},
                {802, 1580},
                {461, 538},
                {543, 909},
                {330, 1090},
                {802, 1343},
                {667, 1506},
                {188, 576},
                {496, 1214},
                {343, 1213},
                {251, 1209},
                {927, 1750},
                {60, 1029},
                {23, 929},
                {517, 1234},
                {798, 1291},
                {954, 1105},
                {555, 1015},
                {19, 677},
                {695, 1306},
                {181, 189},
                {283, 379},
                {749, 780},
                {338, 722},
                {247, 743},
                {544, 1024},
                {654, 907},
                {659, 754},
                {525, 1509},
                {72, 123},
                {621, 929},
                {665, 1178},
                {872, 1046},
                {630, 1095},
                {190, 521},
                {553, 642},
                {813, 1606},
                {63, 152},
                {190, 1164},
                {228, 554},
                {725, 1203},
                {822, 1457},
                {346, 1053},
                {605, 1242},
                {910, 1731},
                {513, 1199},
                {640, 717},
                {396, 832},
                {665, 949},
                {305, 1148},
                {180, 613},
                {462, 886},
                {154, 1053},
                {750, 1101},
                {612, 832},
                {858, 1194},
                {603, 674},
                {73, 518},
                {325, 1072},
                {917, 1405},
                {56, 831},
                {648, 1130},
                {372, 420},
                {647, 1294},
                {604, 1158},
                {790, 1182},
                {14, 26},
                {845, 1614},
                {563, 930},
                {881, 1349},
                {296, 1256},
                {77, 906},
                {518, 761},
                {586, 986},
                {944, 1914},
                {756, 1740},
                {379, 546},
                {16, 417},
                {274, 625},
                {691, 819},
                {3, 82},
                {989, 1119},
                {139, 590},
                {670, 848},
                {905, 1166},
                {919, 1854},
                {338, 1132},
                {276, 1097},
                {921, 1908},
                {112, 851},
                {978, 1829},
                {665, 1494},
                {495, 1299},
                {774, 1088},
                {386, 674},
                {807, 968},
                {372, 1120},
                {196, 715},
                {357, 668},
                {985, 1453},
                {317, 753},
                {256, 1256},
                {954, 1917},
                {391, 783},
                {155, 706},
                {563, 1480},
                {253, 753},
                {661, 684},
                {988, 1043},
                {316, 857},
                {868, 1439},
                {587, 747},
                {960, 1129},
                {709, 1182},
                {818, 841},
                {847, 1207},
                {133, 905},
                {748, 1107},
                {248, 1131},
                {206, 964},
                {371, 1345},
                {12, 84},
                {247, 452},
                {375, 1077},
                {481, 561},
                {657, 811},
                {999, 1784},
                {704, 1543},
                {55, 100},
                {447, 1334},
                {564, 1528},
                {159, 796},
                {961, 1600},
                {644, 1568},
                {443, 1284},
                {746, 1641},
                {458, 1011},
                {994, 1085},
                {793, 1689},
                {215, 281},
                {567, 1557},
                {46, 719},
                {413, 1334},
                {837, 1345},
                {608, 1409},
                {259, 364},
                {985, 1366},
                {601, 1515},
                {147, 1109},
                {887, 1710},
                {116, 882},
                {882, 1333},
                {272, 880},
                {973, 1515},
                {843, 981},
                {901, 1280},
                {806, 1031},
                {122, 420},
                {164, 776},
                {282, 595},
                {149, 569},
                {688, 1375},
                {826, 989},
                {165, 1038},
                {1, 697},
                {582, 1446},
                {964, 1725},
                {31, 633},
                {173, 191},
                {573, 781},
                {237, 1147},
                {698, 1203},
                {566, 816},
                {221, 434},
                {589, 1255},
                {576, 1341},
                {404, 1011},
                {742, 1150},
                {254, 1092},
                {156, 717},
                {876, 1155},
                {295, 902},
                {568, 1139},
                {151, 276},
                {25, 408},
                {115, 974},
                {630, 1455},
                {181, 857},
                {646, 1431},
        });
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        long result  = solve(new int[][]{
//                {1, 2},
//                {2, 3},
//                {4, 5},
//                {6, 7},
//        }, new int[][]{
//                {1, 5},
//                {2, 3},
//                {4, 7},
//                {5, 7},
//        });
//        System.out.println(result);
//    }
}
