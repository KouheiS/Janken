import java.util.Random;

class Player{
	private int m_nResult;
	private int m_nHand;
	private String m_strHand;
	Random rnd = new Random();

	Player(){
		m_nResult = 0;
		m_strHand = null;
		m_nHand = -1;
	}

	public int pose(){				//ジャンケンの手をランダムに決める
		return m_nHand = rnd.nextInt(3);
	}

	public String hand(){
		if(m_nHand == 0){
			m_strHand = "チョキ";
		}else if(m_nHand == 1){
			m_strHand = "グー";
		}else if(m_nHand == 2){
			m_strHand = "パー";
		}

		return m_strHand;
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

		int p1Hand, p2Hand;
		String strResult = null;

		p1Hand = player1.retPose();
		p2Hand = player2.retPose();

		if(p1Hand == p2Hand){					//あいこの場合
				System.out.println("あいこです。");
			}else if((p1Hand == 0 && p2Hand == 2) || (p1Hand == 2 && p2Hand == 1)){
					if(p1Hand == 0){
						player1.Win();
						return strResult = "プレイヤー１が勝ちました！";
					}else{
						player2.Win();
						return strResult = "プレイヤー２が勝ちました！";
					}
			}else{
				if(p1Hand > p2Hand){
					player1.Win();
					return strResult = "プレイヤー１が勝ちました！";
				}else{
					player2.Win();
					return strResult = "プレイヤー１が勝ちました！";
				}
			}
		return strResult;
	}

	public void Winer(Player player1, Player player2){
		if(player1.Result() == player2.Result()){
			System.out.println("引き分けです。");
		}else if(player1.Result() > player2.Result()){
			System.out.println("" +player1.Result() + "対" +"" +player2.Result() +"でプレイヤー１の勝利です。");
		}else{
			System.out.println(""+player1.Result() + "対" +"" +player2.Result() +"でプレイヤー２の勝利です。");
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
			System.out.println("【" + (i+1) + "回戦目】");

			player1.pose();
			player2.pose();

			System.out.println(player1.hand() + "VS" + player2.hand());
			System.out.println(manager.Hantei(player1, player2));

		}

		System.out.println("【ジャンケン終了】");

		manager.Winer(player1, player2);
	}
}
