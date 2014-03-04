import java.util.Random;

class Player{
	private int m_nResult;
	private int m_nHand;
	Random rnd = new Random();

	Player(){
		m_nResult = 0;
		m_nHand = -1;
	}

	public int pose(){				//ジャンケンの手をランダムに決める
		return m_nHand = rnd.nextInt(3);
	}

	public String hand(){
		if(m_nHand == 0){
			return "グー";
		}else if(m_nHand == 1){
			return"チョキ";
		}else if(m_nHand == 2){
			return  "パー";
		}
		return null;
	}

	public void Win(){
		m_nResult++;
	}

	public int Result(){
		return m_nResult;
	}

	public int retPose(){
		return m_nHand;
	}
}

class Manager{
	public String Hantei(Player player1, Player player2){
		String strRet;
		int p1Hand, p2Hand;

		p1Hand = player1.retPose();
		p2Hand = player2.retPose();

		int nWiner = 0;
		if(p1Hand < p2Hand){
			nWiner = Math.abs(p1Hand - p2Hand);
		}else if (p1Hand > p2Hand){
			nWiner = 3 - (p1Hand - p2Hand);
		}
		switch(nWiner){
			case 1:
				player1.Win();
				strRet = "プレイヤー１が勝ちました！";
				break;
			case 2:
				player2.Win();
				strRet = "プレイヤー２が勝ちました！";
				break;
			default:
				strRet = "あいこです。";
				break;
		}
		return strRet;
	}

	public String Winer(Player player1, Player player2){
		if(player1.Result() == player2.Result()){
			return "引き分けです。";
		}else if(player1.Result() > player2.Result()){
			return  player1.Result() + "対" + player2.Result() +"でプレイヤー１の勝利です。";
		}else{
			return  player1.Result() + "対" + player2.Result() +"でプレイヤー２の勝利です。";
		}
	}
}




class Janken{
	public static void main(String[] args){
		System.out.println("【ジャンケン開始】");
		Player player1 = new Player();
		Player player2 = new Player();
		Manager manager = new Manager();

		for(int i=0; i<3; i++){						//三回勝負
			MyPrint("【" + (i+1) + "回戦目】");

			player1.pose();
			player2.pose();

			MyPrint(player1.hand() + "VS" + player2.hand());
			MyPrint(manager.Hantei(player1, player2));

		}

		MyPrint("【ジャンケン終了】");

		MyPrint(manager.Winer(player1, player2));
	}

	static void MyPrint(String str){
		System.out.println(str);
	}
}






























