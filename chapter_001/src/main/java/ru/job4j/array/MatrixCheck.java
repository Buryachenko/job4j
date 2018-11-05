package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = false;		
		int cnt_0 = 0;
		int cnt_1 = 0;
		int cnt_2 = 0;
		int cnt_3 = 0;

		if(data.length > 1 && data[0].length > 1) {
			int column = data[0].length - 1;
			for (int i = 0; i < data.length; i++) {
				if (data[i].length > i) {
					if (data[i][i] == true) {
						cnt_0 = cnt_0 + 1;
					} else {
						cnt_1 = cnt_1 + 1;
					}
					if (column >= 0) {
						if (data[i][column] == true) {
							cnt_2 = cnt_0 + 1;
						} else {
							cnt_3 = cnt_1 + 1;
						}
						column = column - 1;
					}
				}
			}
		}

		if(cnt_0 == 0 || cnt_1 == 0) {
			if(cnt_0 == 0 && cnt_1 == 0) {
				result = false;
			}
			else{
				result = true;
			}
		}
		if(cnt_2 == 0 || cnt_3 == 0) {
			if(cnt_2 == 0 && cnt_3 == 0) {
				result = false;
			}
			else{
				result = true;
			}
		}


        return result;
    }
}