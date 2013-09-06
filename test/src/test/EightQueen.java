package test;

public class EightQueen {
/*	
	
�˻ʺ󣺻ʺ�����ںᡢ����б���ϲ��޲����سԵ��������ӡ���ν�8���ʺ���������ϣ���8*8�����񣩣�ʹ����˭Ҳ���ܱ��Ե�������������İ˻ʺ����⡣	
*/	
	public static int fb = 8;
	   
	public static int count =0;

	public static void main(String[] args) {


	int tposition[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	process(tposition, 0); 
	System.out.println(count);
	}


	public static void process(int mr[][], int curstep) {
	if (curstep == fb) {
	printResult(mr);
	count++;
	return;
	}
	int step = 0;
	for (; step < fb; step++) {
	if (lineuUnique(mr, curstep, step)
	&& diagonalUniqueDown(mr, curstep, step)
	&& diagonalUniqueUp(mr, curstep, step)) {
	mr[curstep][step] = 1;
	process(mr, curstep + 1);
	mr[curstep][step] = 0;


	}
	}

	}


	public static boolean lineuUnique(int mr[][], int curstep, int tryline) {
	if (curstep == 0)
	return true;
	int i = 0;
	for (; i < curstep; i++) {
	if (mr[i][tryline] == 1) {
	return false;
	}
	}
	return true;
	}


	public static boolean diagonalUniqueDown(int mr[][], int curstep, int trylin) {
	if (curstep == 0)
	return true;
	int i = trylin - 1;
	int j = curstep - 1;
	while (i >= 0 && j >= 0) {
	if (mr[j][i] == 1)
	return false;
	j--;
	i--;
	}
	return true;
	}


	public static boolean diagonalUniqueUp(int mr[][], int curstep, int trylin) {
	if (curstep == 0)
	return true;
	int i = trylin + 1;
	int j = curstep - 1;
	while (i < fb && j >= 0) {
	if (mr[j][i] == 1)
	return false;
	j--;
	i++;
	}
	return true;
	}


	public static void printResult(int result[][]) {


	int i = 0;
	for (; i < fb; i++) {
	int j = 0;
	for (; j < fb; j++) {
	System.out.print(result[i][j] + " ");
	}
	System.out.println("");


	}
	System.out.println("----------------------------------------------");
	}
}
