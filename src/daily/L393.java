package daily;

public class L393 {
	public static void main(String[] args) {
		new L393();
	}

	L393() {
		validUtf8(new int[] { 235, 140, 4 });
	}

	public boolean validUtf8(int[] data) {
		int ch = 0;
		for (int i : data) {
			if (ch == 0) {
				if ((i & 248) == 240) {
					ch = 3;
				} else if ((i & 240) == 224) {
					ch = 2;
				} else if ((i & 224) == 192) {
					ch = 1;
				} else if ((i & 128) == 0) {
					ch = 0;
				} else {
					return false;
				}
			} else {
				if (i >> 6 != 2) {
					return false;
				}
				ch--;
			}
		}
		return ch == 0;
	}
}
