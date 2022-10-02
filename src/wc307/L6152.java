package wc307;

public class L6152 {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int hour = 0;
		for (int i = 0; i < energy.length; i++) {
			if (energy[i] >= initialEnergy) {
				int tmp = energy[i] - initialEnergy + 1;
				hour += tmp;
				initialEnergy += tmp;
			}
			if (experience[i] >= initialExperience) {
				int tmp = experience[i] - initialExperience + 1;
				hour += tmp;
				initialExperience += tmp;
			}
			initialEnergy -= energy[i];
			initialExperience += experience[i];
		}
		return hour;
	}
}
