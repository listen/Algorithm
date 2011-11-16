package lib;

public class isWinning {
	public boolean isValid(){
		
	}
	boolean isWinning(position pos){
		if (isValid(pos)){
			return false/true;
		}
		if (pos == end){
	 		return true/false;//根据题意
	 	}
	 	moves[] = possible position to which I can move from pos
		for (all x in moves)
			if(!isWinning(x))
				return true;
		return false;
	}
}
