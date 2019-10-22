package blahBlah;

//import java.util.Map;

public class Timer {
	
	private String name;
	private int workTime = 0;
	private int restTime = 0;
	private int roundNumber = 1;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public int getRestTime() {
		return restTime;
	}

	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	public int getTotalRounds() {
		return totalRounds;
	}

	public void setTotalRounds(int totalRounds) {
		this.totalRounds = totalRounds;
	}

	private int totalRounds = 0;
	
	public Timer(String givenName,int givenWork, int givenRest, int givenTotalRounds) {
		this.name = givenName;
		this.restTime = givenRest;
		this.workTime = givenWork;
		this.totalRounds = givenTotalRounds;
	}
	public Timer() {
		
	}
	
	public void printTimerInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Work time: " + this.workTime);
		System.out.println("Name: " + this.restTime);
		System.out.println("Current Round: " + this.roundNumber);
		System.out.println("Total Rounds: " + this.totalRounds);
	}
	
	public boolean executeTimer() {
		boolean complete = false;
		while (this.roundNumber <= this.totalRounds) {
			System.out.println("Round: " + this.roundNumber);
			this.executeInterval(this.workTime);
			if(this.roundNumber != this.totalRounds) {
				this.executeInterval(this.restTime);
			}
			this.roundNumber++;
		}
		complete = true;
		return complete;
	}
	
	public boolean executeInterval(int givenTime){
		int iterations = givenTime;
		boolean result = false;
		
		while(iterations > 0) {
			System.out.println("Time remaining: " + iterations);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iterations --;
		}
		
		result = true;
		return result;
	}
	

}
