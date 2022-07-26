public class Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
    /**
     * [Performance]
     * Time Limit Exceeded
     * @param nums input
     * @return largest summation
     */
    public static int maximumSum(int[] nums) {
        int max = -1;
        int leng = nums.length;
        int save[][] = new int[leng][11];
        for (int i = 0; i < leng; i++) { // O(n)
            String a = nums[i] + "";
            int sum = 0;
            for (int m = 0; m < a.length(); m++) // amount of digits
                save[i][(a.charAt(m) - '0')]++;
            for (int m = 0; m < 10; m++) // calculate sum
                sum += save[i][m] * m;
            save[i][10] = sum;
        }
        for (int i = 0; i < leng - 1; i++) { // O(nlogn)
            int sum_a = save[i][10];
            for (int j = i + 1; j < leng; j++) {
                int sum_b = save[j][10];
                if (i != j && sum_a == sum_b) {
                    int sum = nums[i] + nums[j];
                    if (sum > max)
                        max = sum;
                }
            }
        }
        return max;
    }

    /**
     * [Performance]
     * Runtime: 533 ms, faster than 5.07% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * Memory Usage: 59.2 MB, less than 66.09% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * @param nums input
     * @return largest summation
     */
    public static int maximumSum2(int[] nums) {
        // the max sum is 81, so we save all sum and their index
        // later we will only calculate the value of index with same sum
        int max = -1;
        int leng = nums.length;
        int sum_index[][] = new int[82][10001]; // nums.length <= 10^5
        /** calculate digits sum **/
        for (int i = 0; i < leng; i++) { // loop of nums
            String a = nums[i] + "";
            int sum = 0;
            for (int j = 0; j < a.length(); j++) // loop of digits
                sum += a.charAt(j) - '0'; // or, will "divide by 10" be faster?
            sum_index[sum][sum_index[sum][10000]] = nums[i];
            sum_index[sum][10000]++; // use last extra index to record the size
        }
        /** find largest sum of "same digits sum" nums **/
        for (int n = 0; n < 82; n++) {
            int amount = sum_index[n][10000];
            for (int a_index = 0; a_index < amount; a_index++) {
                for (int b_index = a_index + 1; b_index < amount; b_index++) {
                    int sum = sum_index[n][a_index] + sum_index[n][b_index];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    /**
     * [Performance]
     * Runtime: 153 ms, faster than 21.47% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * Memory Usage: 129.9 MB, less than 5.03% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * @param nums input
     * @return largest summation
     */
    public static int maximumSum3(int[] nums) {
        // if I can build a heap array with size of 81, which is heap[81]
        // then I can sort the nums while adding them
        // after that, I just need to add the largest two numbers in each heap
        // that is only 81 times of additions
        // (actually is 81*2 time additions, since heap cannot directly get second larger number)
        int leng = nums.length;
        MaxHeap arr[] = new MaxHeap[81];
        int temp_i = 0;
        do {
            arr[temp_i] = new MaxHeap();
            temp_i++;
        } while (temp_i < 81);
        for (int i = 0; i < leng; i++) { // loop of nums
            int num = nums[i];
            int sum = 0;
            while (num != 0) { // loop of digits
                sum += num % 10; // or, will "remaining of divide by 10" be faster?
                num /= 10;
            }
            arr[sum - 1].add(nums[i]); // add to max heap
        }
        int max = -1;
        for (int i = 0; i < 81; i++) {
            if (arr[i].length < 2)
                continue;
            else if (arr[i].length < 3) {
                int sum = arr[i].array[0] + arr[i].array[1];
                if (sum > max)
                    max = sum;
            } else {
                int sum = arr[i].array[1] > arr[i].array[2] ? arr[i].array[0] + arr[i].array[1]
                        : arr[i].array[0] + arr[i].array[2];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    /**
     * [Performance]
     * Runtime: 62 ms, faster than 83.42% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * Memory Usage: 57.6 MB, less than 83.50% of Java online submissions for Max Sum of a Pair With Equal Sum of Digits.
     * @param nums input
     * @return largest summation
     */
    public static int maximumSum3SpaceOptimized(int[] nums) {
        int leng = nums.length;
        MaxHeap arr[] = new MaxHeap[81];
        for (int i = 0; i < leng; i++) {
            int num = nums[i];
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if (arr[sum - 1] == null)
                arr[sum - 1] = new MaxHeap();
            arr[sum - 1].add(nums[i]);
        }
        int max = -1;
        for (int i = 0; i < 81; i++) {
            if (arr[i] == null)
                continue;
            if (arr[i].length < 2)
                continue;
            else if (arr[i].length < 3) {
                int sum = arr[i].array[0] + arr[i].array[1];
                if (sum > max)
                    max = sum;
            } else {
                int sum = arr[i].array[1] > arr[i].array[2] ? arr[i].array[0] + arr[i].array[1]
                        : arr[i].array[0] + arr[i].array[2];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum3SpaceOptimized(new int[] {
                690992339, 103818011, 366056477, 695134609, 84800508, 25430336, 416187020,
                593871750, 392197845, 500153808, 894390533, 242464164, 541488323, 995525321, 58049250,
                72792696, 175433677, 826938449, 38612857, 261244469, 971822570, 246193894, 787973790, 422862379,
                759565285, 92767125, 59772559, 633612559, 879541035, 375284627, 838720721, 959464404, 85904732,
                236501370, 721623342, 833250880, 948483245, 703312036, 873625855, 309990547, 765893988, 322886454,
                914458089, 231401440, 212705916, 186319056, 285925045, 972685665, 147151139, 659273469, 423164430,
                927111469, 384878155, 90171613, 399785377, 158124976, 130215630, 416758014, 641380282, 326923942,
                299981886, 53089697, 892886488, 345559396, 578414978, 532789242, 748870485, 702021708, 448909087,
                740937043, 521799301, 406677487, 826431612, 504700881, 124381384, 68815314, 758719227, 387906919,
                242231251, 393397759, 965495411, 664281984, 552142778, 852285441, 355718510, 287029434, 851879497,
                663020125, 737966645, 598824213, 917833532, 452487383, 122009227, 537133474, 341577242, 261157413,
                242314285, 12427620, 105817636, 834293163, 316860846, 730582250, 274256077, 949099347, 640797545,
                72147280, 31081128, 559221005, 657162177, 719450222, 186314716, 51209227, 272503749, 461339529,
                144155812, 441925805, 606324445, 711688672, 409059467, 237485733, 297248336, 193376804, 324909437,
                985985531, 315725383, 273379240, 596870955, 604145096, 379096091, 188885636, 544542563, 461201708,
                498830005, 330556529, 463019430, 848648809, 591055560, 933263087, 203231150, 237939263, 886187132,
                854257497, 757162306, 766729309, 688326507, 16396821, 19020864, 33463141, 379050392, 190870925,
                326688267, 50139312, 73175051, 254576047, 163475387, 509394893, 503296203, 404858977, 545332473,
                839902453, 38661317, 995331494, 637023436, 837864102, 772823001, 708005880, 279782695, 263622206,
                833049743, 838656736, 242036196, 590239724, 361647452, 415169473, 709606767, 856747424, 858549713,
                809478875, 604373576, 210948440, 196524190, 961006268, 559066136, 674078529, 423102671, 204448957,
                74605823, 611157025, 200267169, 181194371, 498888307, 475611564, 855805557, 671046555, 858096254,
                194697941, 269226179, 433935847, 434607947, 613081871, 639313323, 257592221, 689797739, 610308000,
                129227829, 335078537, 196473463, 904701602, 869240813, 965960667, 226832307, 304286286, 400154541,
                996032241, 857993987, 531530913, 563682995, 493312872, 306368020, 672170159, 808331758, 730577273,
                237166978, 677659107, 201525329, 391580198, 206126982, 505196081, 873815163, 153364852, 35550682,
                310705914, 136487600, 119134078, 345432935, 817479648, 95325870, 139781055, 476755324, 84472966,
                971097417, 72208654, 154263767, 381951987, 851473999, 245549612, 55665849, 626379237, 304274133,
                943613541, 867820631, 999507902, 699785600, 401238902, 176813014, 386748933, 994686959, 26567599,
                979310882, 440940578, 882080012, 822269088, 844206028, 195080943, 129567213, 153885328, 686441081,
                740814795, 472470910, 671186234, 904431566, 131870294, 663854331, 715261134, 777487429, 485965937,
                846733344, 553347493, 590517713, 261203486, 579593247, 710422754, 926146513, 453054136, 944814401,
                135886131, 895474126, 531404579, 523111038, 87664513, 916249731, 976023857, 816218199, 753269550,
                330045859, 900515376, 371562081, 328061461, 856770067, 869901538, 10562999, 47484203, 706162986,
                137635790, 690385958, 42147932, 677988532, 801268443, 795378154, 656093387, 427849589, 602658764,
                33343371, 395815090, 325114413, 163103359, 711316020, 776625731, 161927012, 560926935, 35271007,
                972723772, 575799098, 770823108, 817915853, 89959960, 122913598, 252139112, 291481690, 157641872,
                311853732, 870947241, 831384453, 716303208, 725503751, 745876926, 971447328, 981596398, 959709259,
                754211930, 986746319, 924674686, 984528084, 491766157, 445554853, 449074992, 72957413, 120865617,
                854502314, 694223349, 607157026, 376634562, 861768130, 37950376, 804963978, 130035074, 114666300,
                663545596, 158303979, 146768793, 122142001, 640043802, 519229841, 741960624, 9695771, 241717026,
                701300389, 182364999, 12650836, 17454335, 260584180, 17866976, 555036129, 416542768, 25760674,
                605181898, 577367627, 820019952, 826828691, 380629549, 518108948, 389811731, 458276609, 325288943,
                500323628, 363614943, 620760659, 112615815, 800819702, 843731831, 984033946, 256135843, 733949228,
                325528615, 638273288, 385106187, 796722800, 11272627, 289524724, 840522647, 687612637, 627781502,
                214259512, 611373767, 447083732, 887068818, 967920668, 310069017, 843496388, 989373464, 115318693,
                819790989, 751188164, 518840410, 966943106, 114750146, 86115586, 779583218, 250687119, 683552923,
                816024141, 977751243, 701330174, 377627608, 764049039, 632049193, 819243111, 362316529, 104939320,
                260046926, 484793018, 415470193, 961470201, 705267765, 460990316, 149241404, 547299820, 150226470,
                860098912, 643625467, 924992137, 586229831, 57894722, 513732268, 748796690, 123405876, 274553706,
                938288143, 865388751, 774036683, 504368984, 441789287, 56555435, 845567353, 230631431, 268640538,
                269608942, 536680625, 751174490, 566617437, 609818655, 173921912, 327777168, 699114173, 545672239,
                29403621, 317293070, 586416073, 111918760, 144503492, 556730174, 993047960, 294607305, 135150729,
                890590400, 769923005, 617597341, 959777184, 534346756 }));
    }
}

/** MaxHeap will keep maximum integer at the top,
 * All children are smaller than their parent.
*/
class MaxHeap {
    int array[];
    int length;

    MaxHeap() {
        array = new int[10000];
        length = 0;
    }

    void add(int num) {
        array[length] = num;
        int index = length;
        int parentIndex = (index - 1) / 2;
        while (index > 0 && array[parentIndex] < num) {
            int temp = array[parentIndex];
            array[parentIndex] = num;
            array[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        length++;
    }
}
