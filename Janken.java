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
}




class Janken{
	public static void main(String[] args){
		System.out.println("【ジャンケン開始】");
		Player player1 = new Player();
		Player player2 = new Player();

		int p1Hand, p2Hand;

		for(int i=0; i<3; i++){						//三回勝負
			System.out.println("【" + i + "回戦目】");

			p1Hand = player1.pose();
			p2Hand = player2.pose();

			Hantei(p1Hand, p2Hand, player1, player2);

		}

		System.out.println("【ジャンケン終了】");

		Winer(player1, player2);
	}

	static void Hantei(int p1Hand, int p2Hand, Player player1, Player player2){
		if(p1Hand == p2Hand){					//あいこの場合
				System.out.println(player1.hand() + "VS" + player2.hand());
				System.out.println("あいこです。");
			}else if((p1Hand == 0 && p2Hand == 2) || (p1Hand == 2 && p2Hand == 1)){
					System.out.println(player1.hand() + "VS" + player2.hand());
					if(p1Hand == 0){
						System.out.println("プレイヤー１が勝ちました！");
						player1.Win();
					}else{
						System.out.println("プレイヤー2が勝ちました！");
						player2.Win();
					}
			}else{
				System.out.println(player1.hand() + "VS" + player2.hand());

				if(p1Hand > p2Hand){
					System.out.println("プレイヤー１が勝ちました！");
					player1.Win();
				}else{
					System.out.println("プレイヤー2が勝ちました！");
					player2.Win();
				}
			}
	}

	static void Winer(Player player1, Player player2){
		if(player1.Result() == player2.Result()){
			System.out.println("引き分けです。");
		}else if(player1.Result() > player2.Result()){
			System.out.println("" +player1.Result() + "対" +"" +player2.Result() +"でプレイヤー１の勝利です。");
		}else{
			System.out.println(""+player1.Result() + "対" +"" +player2.Result() +"でプレイヤー２の勝利です。");
		}
	}
}
