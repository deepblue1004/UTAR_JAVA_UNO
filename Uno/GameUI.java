// GameUI.java

package Uno;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameUI extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		setGameMode(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	// Let player choose game mode
	public static void setGameMode(Stage primaryStage) {
		BorderPane bPane = new BorderPane();
		bPane.setStyle("-fx-border-color: black; "
					+ "-fx-border-width: 10px; "
					+ "-fx-padding: 20px; "
					+ "-fx-background-color: #990000; ");
		
		// <head>
		VBox vbTitle = new VBox();
		vbTitle.setStyle("-fx-alignment: center; ");
		
		Text txTitle = new Text("Welcome To Java Uno Game!");
		txTitle.setStyle("-fx-fill: #d8d8d8; "
					+ "-fx-font: 70px \"Britannic Bold\"; ");
		
		Line lnDivide = new Line(0, 0, 1000, 0);
		lnDivide.setStyle("-fx-stroke-width: 5px; ");
		
		Text txChoosePlayer = new Text("Select a game mode!");
		txChoosePlayer.setStyle("-fx-fill: #ffafaf; "
					+ "-fx-font: 50px \"Arial Black\"; ");
		
		vbTitle.getChildren().addAll(txTitle, lnDivide, txChoosePlayer);
		bPane.setTop(vbTitle);
		// </head>
		
		// <body>
		VBox vbBody = new VBox(10);
		vbBody.setAlignment(Pos.CENTER);
		
		Button[] btnMode = new Button[3];
		
		for (int i = 0; i < 3; i++) {
			final int BUTTON_INDEX = i;
			btnMode[i] = new Button((i + 2) + " Players Mode");
			String btnMode_Normal = "-fx-background-color: #555555; " 
					+ "-fx-border-color: white; "
					+ "-fx-text-fill: white; "
					+ "-fx-text-align: center; "
					+ "-fx-font-size: 50px; ";
			String btnMode_Hover = "-fx-background-color: white; " 
					+ "-fx-border-color: #555555; "
					+ "-fx-text-fill: #555555; "
					+ "-fx-text-align: center; "
					+ "-fx-font-size: 50px; ";
			String btnMode_Click = "-fx-background-color: white; "
					+ "-fx-border-color: #d87f7f; "
					+ "-fx-border-width: 10px; "
					+ "-fx-text-fill: #555555; "
					+ "-fx-text-align: center; "
					+ "-fx-font-size: 50px; ";
			
			btnMode[i].setStyle(btnMode_Normal);
			btnMode[i].setOnMouseMoved(e -> {
				btnMode[BUTTON_INDEX].setStyle(btnMode_Hover);
			});
			
			btnMode[i].setOnMouseExited(e -> {
				btnMode[BUTTON_INDEX].setStyle(btnMode_Normal);
			});
			
			btnMode[i].setOnMousePressed(e -> {
				btnMode[BUTTON_INDEX].setStyle(btnMode_Click);
			});
			
			btnMode[i].setOnAction(e -> {
				setPlayerName(primaryStage, BUTTON_INDEX + 2);
			});

			
		}
		vbBody.getChildren().addAll(btnMode);
		bPane.setCenter(vbBody);
		// </body>
		
		
		Scene scene = new Scene(bPane, 1120, 630);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Java UNO GAME!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// Set player name
	public static void setPlayerName(Stage primaryStage, int aNum) {
		String[] playerName = new String[aNum];
		BorderPane bPane = new BorderPane();
		bPane.setStyle("-fx-border-color: black; "
				+ "-fx-border-width: 10px; "
				+ "-fx-padding: 20px; "
				+ "-fx-background-color: #990000; ");
		ImageView imgvBtnBack = new ImageView("img/btnBack.png");
		imgvBtnBack.setFitWidth(50);
		imgvBtnBack.setFitHeight(50);
		// <head>
		
		
		VBox vbTitle = new VBox();
		vbTitle.setStyle("-fx-alignment: center; ");
		
		Text txTitle = new Text("Welcome To Java Uno Game!");
		txTitle.setStyle("-fx-fill: #d8d8d8; "
					+ "-fx-font: 70px \"Britannic Bold\"; ");
		
		Line lnDivide = new Line(0, 0, 1000, 0);
		lnDivide.setStyle("-fx-stroke-width: 5px; ");
		
		Text txSetname = new Text("Enter Player Name");
		txSetname.setStyle("-fx-fill: #ffafaf; "
					+ "-fx-font: 50px \"Arial Black\"; ");
		
		HBox hbBackTitle = new HBox(30);
		hbBackTitle.getChildren().addAll(imgvBtnBack,txTitle);
		
		vbTitle.getChildren().addAll(hbBackTitle, lnDivide, txSetname);
		bPane.setTop(vbTitle);
		imgvBtnBack.setOnMouseClicked(e -> {
			setGameMode(primaryStage);
		});
		// </head>
		
		// <body>
		VBox vbBody = new VBox(10);
		vbBody.setMaxSize(550, 320);
		vbBody.setStyle("-fx-alignment: center; "
					+ "-fx-border-color: #778cdd; "
					+ "-fx-border-width: 10px; "
					+ "-fx-padding: 25px; ");
		
		HBox[] hbPlayerName = new HBox[aNum];
		Text[] txPlayerName = new Text[aNum];
		TextField[] tfPlayerName = new TextField[aNum];
		
		for(int i = 0; i < aNum; i++) {
			final int INDEX = i;
			hbPlayerName[i] = new HBox(5);
			txPlayerName[i] = new Text("Player " + (i + 1) + ": ");
			txPlayerName[i].setStyle("-fx-fill: #aabbff; "
					+ "-fx-font: 40px \"Calibri\"; ");
			
			tfPlayerName[i] = new TextField();
			tfPlayerName[i].setOnKeyTyped(event ->{
		        if (tfPlayerName[INDEX].getText().length() >= 5) 
		        	event.consume();
		    });
			tfPlayerName[i].setStyle("-fx-background-color: transparent; "
					+ "-fx-border-color: #aabbff; "
					+ "-fx-border-width: 0 0 5 0; "
					+ "-fx-text-fill: #dde4ff; "
					+ "-fx-font: 22px \"Arial Black\"; ");
			
			hbPlayerName[i].getChildren().addAll(txPlayerName[i], tfPlayerName[i]);
			vbBody.getChildren().add(hbPlayerName[i]);
		}

		bPane.setCenter(vbBody);
		// </body>
		
		// <footer>
		String btnStart_Normal = "-fx-background-color: #555555; " 
				+ "-fx-border-color: white; "
				+ "-fx-text-fill: white; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		String btnStart_Hover = "-fx-background-color: white; " 
				+ "-fx-border-color: #555555; "
				+ "-fx-text-fill: #555555; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		String btnStart_Click = "-fx-background-color: white; "
				+ "-fx-border-color: #d87f7f; "
				+ "-fx-border-width: 5px; "
				+ "-fx-text-fill: #555555; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		
		Button btnStart = new Button("Start Game");
		btnStart.setStyle(btnStart_Normal);
		
		btnStart.setOnMouseMoved(e -> {
			btnStart.setStyle(btnStart_Hover);
		});
		
		btnStart.setOnMouseExited(e -> {
			btnStart.setStyle(btnStart_Normal);
		});
		
		btnStart.setOnMousePressed(e -> {
			btnStart.setStyle(btnStart_Click);
		});
		
		btnStart.setOnAction(e -> {
			for (int i = 0; i < aNum; i++) {
				playerName[i] = tfPlayerName[i].getText();
			}
			startGame(primaryStage, playerName);
		});
		
		bPane.setBottom(btnStart);
		BorderPane.setAlignment(btnStart, Pos.BOTTOM_CENTER);
		// </footer>
		
		Scene scene = new Scene(bPane, 1120, 630);
		
		primaryStage.setScene(scene);
	}
	
	// Start the game
	public static void startGame(Stage primaryStage, String[] playerName) {
		Game myGame = new Game(playerName);
		BorderPane bPane = new BorderPane();
		bPane.setStyle("-fx-background-image: url(\"/img/broad.png\"); "
				+ "-fx-border-color: black; "
				+ "-fx-border-width: 9; ");
		Scene scene = new Scene(bPane, 1120, 630);
		primaryStage.setScene(scene);
		
		// Method Inner Class for Game GUI 
		class InGame {
			// Show the GUI header (player information)
			private void showHeader() {
				HBox hbHead = new HBox(1);
				hbHead.setStyle("-fx-padding: 1; -fx-alignment: center; "); 
				HBox[] hbPlayerInfo = new HBox[myGame.getPlayerCount()];
				ImageView[] imgvPlayerInfo = new ImageView[myGame.getPlayerCount()]; 
				Text[] txPlayerName = new Text[myGame.getPlayerCount()];
				
				String hbStyle_Play = "-fx-border-color: #1228b5; "
						+ "-fx-border-width: 5; "
						+ "-fx-background-color: rgba(165, 177, 255, 0.9); ";
				String hbStyle_Wait = "-fx-border-color: #b52913; "
						+ "-fx-border-width: 5; "
						+ "-fx-background-color: rgba(255, 175, 175, 0.9); ";
				String txStyle_Play = "-fx-fill: #1228b5; "
						+ "-fx-font: 25px \"Arial Black\"; ";
				String txStyle_Wait = "-fx-fill: #b52913; "
						+ "-fx-font: 25px \"Arial Black\"; ";
				for (int i = 0; i < myGame.getPlayerCount(); i++) {
					hbPlayerInfo[i] = new HBox(5);
					hbPlayerInfo[i].setStyle(hbStyle_Wait);
					hbPlayerInfo[i].getChildren().clear();
					
					imgvPlayerInfo[i] = new ImageView("img/Back.png");

					imgvPlayerInfo[i].setFitWidth(131);
					imgvPlayerInfo[i].setFitHeight(187);
					
					txPlayerName[i] = new Text("Player " + (i + 1) + ": \n" 
									+ myGame.getPlayer(i).getName() + "\n\n"
									+ myGame.getPlayer(i).getCard().size() + " Card");
					txPlayerName[i].setStyle(txStyle_Wait);
					
					hbPlayerInfo[i].getChildren().addAll(imgvPlayerInfo[i], txPlayerName[i]);			
				}
				if (!myGame.endGame()) {
					txPlayerName[myGame.getPlayIndex()].setStyle(txStyle_Play);
					txPlayerName[myGame.getPlayIndex()].setText(
							txPlayerName[myGame.getPlayIndex()].getText() + "\n(Playing)"
					);
					hbPlayerInfo[myGame.getPlayIndex()].setStyle(hbStyle_Play);	
				}
				
				hbHead.getChildren().addAll(hbPlayerInfo);
				bPane.setTop(hbHead);
			}
		
			// Show current player's hand card
			private void showPlayerHand(boolean checkPlayable) {
				HBox hbPlaying = new HBox(5);
				if (myGame.getPlayingCard().size() < 5)
					hbPlaying.setSpacing(5);
				else if (myGame.getPlayingCard().size() < 8)
					hbPlaying.setSpacing(-30);
				else
					hbPlaying.setSpacing(-80);
				hbPlaying.setStyle("-fx-padding: 5; "
							+ "-fx-alignment: center; "
							+ "-fx-background-color: rgba(0, 0, 0, 0.4); ");
				
				ImageView[] imgvPlaying = new ImageView[myGame.getPlayingCard().size()];
				for (int i = 0; i < myGame.getPlayingCard().size(); i++) {
					imgvPlaying[i] = new ImageView(myGame.getPlayingCard(i).getPath());
					imgvPlaying[i].setFitWidth(131);
					imgvPlaying[i].setFitHeight(187);
					hbPlaying.getChildren().add(imgvPlaying[i]);
				}
				bPane.setBottom(hbPlaying);
				
				if (checkPlayable == true) {
					if (myGame.getPlaying().isPlayable(myGame.getFromPile(0)).size() > 0) {
						for (int i = 0; i < myGame.getPlayingCard().size(); i++) {
							final int INDEX = i;
							imgvPlaying[i].setOnMouseClicked(e -> {
								Card tempCard = myGame.getPlayingCard(INDEX);
								if (myGame.getFromPile(0).isMatch(tempCard)) {
									myGame.addToPile(tempCard);
									myGame.getPlaying().removeCard(INDEX);
									if(myGame.endGame())
										gameEnd(primaryStage, myGame);
									else
										drawAction(tempCard.action(myGame));
								}
								else {
									Alert alert = new Alert(AlertType.ERROR);
									alert.setTitle("Discard Fail");
									alert.setContentText("Discard Fail: Card Not Match!");
									alert.showAndWait();
								}
							});
						}
					}
					else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Player " + (myGame.getPlayIndex() + 1));
						alert.setHeaderText("No Playable Card");
						alert.setContentText("A card will draw from deck.");
						alert.showAndWait();
						
						Card tempCard = myGame.drawFromDeck();
						myGame.getPlaying().addCard(tempCard);
						
						if (myGame.getFromPile(0).isMatch(tempCard)) {
							drawMatch(tempCard);
						}
						else {
							showDrawedCard(new Card[] {tempCard}, "Card draw from deck but still not match.");
							myGame.nextPlayer();
						}
					}
				}
			}
				
			// Show deck and pile
			private void showDeckPile() {
				String deckPileText = "-fx-fill: white; "
									+ "-fx-font: 25px \"Arial Black\"; ";
				String btnDeck_Normal = "-fx-background-color: white; " 						
						+ "-fx-border-radius: 20px; "
						+ "-fx-text-fill: black; "
						+ "-fx-text-align: center; "
						+ "-fx-font-size: 20px; ";
				String btnDeck_Hover = "-fx-background-color: #222; "
						+ "-fx-border-color: white;"
						+ "-fx-border-width: 1px;"					
						+ "-fx-text-fill: white; "
						+ "-fx-text-align: center; "
						+ "-fx-font-size: 20px; ";
				String btnDeck_Click = "-fx-background-color: black; "
						+ "-fx-border-radius: 20px; "
						+ "-fx-text-fill: white; "
						+ "-fx-text-align: center; "
						+ "-fx-font-size: 20px; ";
				HBox hbDeckPile = new HBox(10);
				hbDeckPile.setAlignment(Pos.CENTER); 
				
				HBox hbPile = new HBox(10);
				hbPile.setAlignment(Pos.CENTER_RIGHT);
				ImageView imgvPile = new ImageView(myGame.getFromPile(0).getPath());
				imgvPile.setFitWidth(131);
				imgvPile.setFitHeight(187);
				
				hbPile.getChildren().addAll(imgvPile);
				
				HBox hbDeck = new HBox(10);
				hbDeck.setAlignment(Pos.CENTER_LEFT);
				
				ImageView imgvDeck = new ImageView("img/Back.png");
				imgvDeck.setFitWidth(131);
				imgvDeck.setFitHeight(187);
				
				VBox vbDeck = new VBox(5);
				vbDeck.setAlignment(Pos.CENTER_LEFT); 
				Text txDeck = new Text("Deck: \n" + myGame.deckCount() + " Card\n");
				txDeck.setStyle(deckPileText);
				
				
				Button btnDeck = new Button("Draw from deck");
				btnDeck.setOnMouseMoved(e-> {
					btnDeck.setStyle(btnDeck_Hover);
				});
				
				btnDeck.setOnMouseExited(e->{
					btnDeck.setStyle(btnDeck_Normal);
				});
				
				btnDeck.setOnMousePressed(e->{
					btnDeck.setStyle(btnDeck_Click);
				});
				btnDeck.setStyle(btnDeck_Normal);
				
				vbDeck.getChildren().addAll(txDeck, btnDeck);
				hbDeck.getChildren().addAll(imgvDeck, vbDeck);
				
				hbDeckPile.getChildren().addAll(hbPile, hbDeck);
				bPane.setCenter(hbDeckPile);
				btnDeck.setOnAction(e -> {
					Card tempCard = myGame.drawFromDeck();
					myGame.getPlaying().addCard(tempCard);
					showDrawedCard(new Card[] {tempCard}, "Player " + (myGame.getPlayIndex() + 1) + " drawed a card");
					myGame.nextPlayer();
				});
			}
			
			// Show cards drawed by player
			private void showDrawedCard(Card[] c, String title) {
				showHeader();
				showPlayerHand(false);
				VBox vbShowDraw = new VBox(5);
				HBox hbShowDraw = new HBox(5);
				hbShowDraw.setAlignment(Pos.CENTER);
				ImageView[] imgvShowDraw = new ImageView[c.length];
				for(int i = 0; i < c.length; i++) {
					imgvShowDraw[i] = new ImageView(c[i].getPath());
					imgvShowDraw[i].setFitHeight(140);
					imgvShowDraw[i].setFitWidth(100);
					hbShowDraw.getChildren().add(imgvShowDraw[i]);
				}
				Text txShowDraw = new Text(title);
				txShowDraw.setStyle("-fx-fill: white; "
						+ "-fx-font: 20px \"Arial Black\"; ");
				
				Button btnOk = new Button("Ok");
				vbShowDraw.setAlignment(Pos.CENTER);
				bPane.setCenter(vbShowDraw);
				btnOk.setOnAction(e -> {
					showHeader();
					showDeckPile();
					showPlayerHand(true);
				});

				vbShowDraw.getChildren().addAll(hbShowDraw, txShowDraw, btnOk);
				
			}
			
			// When the new card draw from deck is match the pile
			private void drawMatch(Card c) {
				showHeader();
				showPlayerHand(false);
				VBox vbShowDraw = new VBox(5);
				vbShowDraw.setAlignment(Pos.CENTER);
				
				ImageView imgvShowDraw = new ImageView(c.getPath());
				imgvShowDraw.setFitHeight(140);
				imgvShowDraw.setFitWidth(100);
				Text txShowDraw = new Text("Card Matched: Do you want to discard?");
				txShowDraw.setStyle("-fx-fill: white; "
						+ "-fx-font: 20px \"Arial Black\"; ");
				
				HBox hbButton = new HBox(10);
				hbButton.setAlignment(Pos.CENTER);
				
				Button[] btnYesNo = new Button[2];
				btnYesNo[0] = new Button("Yes");
				btnYesNo[1] = new Button("No");
				
				btnYesNo[0].setOnAction(e -> {
					myGame.addToPile(c);
					myGame.getPlaying().removeCard(c);
					drawAction(c.action(myGame));
				});	
				
				btnYesNo[1].setOnAction(e -> {
					myGame.nextPlayer();
					showHeader();
					showDeckPile();
					showPlayerHand(true);
				});
				hbButton.getChildren().addAll(btnYesNo);

				vbShowDraw.getChildren().addAll(imgvShowDraw, txShowDraw, hbButton);
				bPane.setCenter(vbShowDraw);
			}
		
			// For draw 2 and draw 4 card
			public void drawAction(int aNum) {
				if (aNum == 0) {
					myGame.nextPlayer();
					showHeader();
					showDeckPile();
					showPlayerHand(true);
					return;
				}
				
				Player playerDraw = myGame.getPlaying();
				int curPlayer = myGame.getPlayIndex() + 1;
				int prePlayer = myGame.prePlayIndex() + 1;
				String message = "";

				if (aNum == 4) {
					showHeader();
					showDeckPile();
					showPlayerHand(false);
					message = "Player " + curPlayer + ": \nDo you want to challenge Player " + prePlayer + "?";
					String title = "Player " + curPlayer + "'s Turn!";
					
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(title);
					alert.setHeaderText(message);
					alert.setContentText("Choose your option.");

					ButtonType btnYes = new ButtonType("Yes", ButtonData.YES);
					ButtonType btnNo = new ButtonType("No", ButtonData.NO);

					alert.getButtonTypes().setAll(btnYes, btnNo);
					Optional<ButtonType> result = alert.showAndWait();
					

					if (result.get() == btnYes) {
						ArrayList<Card> playableCards = myGame.getPrePlaying().isPlayable(myGame.getFromPile(1));
						if (playableCards.size() == 0 || playableCards.size() == 1 && playableCards.get(0).getSymbol() == 14) {
							message = "Challenge Fail: ";
							aNum += 2;
						}
						else {
							message = "Challenge Success: ";
							curPlayer = prePlayer;
							playerDraw = myGame.getPrePlaying();
							myGame.setPlayIndex(myGame.prePlayIndex());
						}
					}
					else
						message = "";
				}

				message += "Player " + curPlayer + " draw " + aNum + " cards from deck";
				Card[] tempCard = new Card[aNum];
				
				for (int i = 0; i < aNum; i++) {
					tempCard[i] = myGame.drawFromDeck();
					playerDraw.addCard(tempCard[i]);
				}
				showDrawedCard(tempCard, message);
				myGame.nextPlayer();
			}
		}
		
		new InGame().showHeader();
		new InGame().showDeckPile();
		new InGame().showPlayerHand(true);
	}

	// Do When A Player Win
	private static void gameEnd(Stage primaryStage, Game aGame) {
		BorderPane bPane = new BorderPane();
		bPane.setStyle("-fx-border-color: black; "
					+ "-fx-border-width: 10px; "
					+ "-fx-padding: 20px; "
					+ "-fx-background-image: url(\"/img/win.jpg\"); ");
		
		// <head>
		VBox vbTitle = new VBox();
		vbTitle.setStyle("-fx-alignment: center; ");
		
		Text txTitle = new Text("Congratulations");
		txTitle.setStyle("-fx-fill: red; "
					+ "-fx-font: 70px \"Britannic Bold\"; ");
		
		Line lnDivide = new Line(0, 0, 1000, 0);
		lnDivide.setStyle("-fx-stroke-width: 5px; ");
		
		Text txChoosePlayer = new Text("Player " + (aGame.getPlayIndex() + 1) + " win the game!");
		txChoosePlayer.setStyle("-fx-fill: black; "
					+ "-fx-font: 50px \"Arial Black\"; ");
		
		vbTitle.getChildren().addAll(txTitle, lnDivide, txChoosePlayer);
		bPane.setTop(vbTitle);
		// </head>
		
		// <body>
		VBox vbBody = new VBox(50);
		vbBody.setAlignment(Pos.CENTER);
		
		Text txBody = new Text("Start a new game?");
		txBody.setStyle("-fx-fill: #222; "
				+ "-fx-font: 50px \"Arial Black\"; ");
		
		HBox hbBody = new HBox(50);
		hbBody.setAlignment(Pos.CENTER);
		
		String btnYesQuit_Normal = "-fx-background-color: #555555; " 
				+ "-fx-border-color: white; "
				+ "-fx-text-fill: white; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		String btnYesQuit_Hover = "-fx-background-color: white; " 
				+ "-fx-border-color: #555555; "
				+ "-fx-text-fill: #555555; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		String btnYesQuit_Click = "-fx-background-color: white; "
				+ "-fx-border-color: #d87f7f; "
				+ "-fx-border-width: 5px; "
				+ "-fx-text-fill: #555555; "
				+ "-fx-text-align: center; "
				+ "-fx-font-size: 30px; ";
		Button[] btnYesQuit = {new Button("Yes"), new Button("Quit")};		
		hbBody.getChildren().addAll(btnYesQuit);
		
		for (int i = 0; i < btnYesQuit.length; i++) {
			final int INDEX = i;
			btnYesQuit[i].setStyle(btnYesQuit_Normal);
			btnYesQuit[i].setOnMouseMoved(e -> {
				btnYesQuit[INDEX].setStyle(btnYesQuit_Hover);
			});
			
			btnYesQuit[i].setOnMouseExited(e -> {
				btnYesQuit[INDEX].setStyle(btnYesQuit_Normal);
			});
			
			btnYesQuit[i].setOnMousePressed(e -> {
				btnYesQuit[INDEX].setStyle(btnYesQuit_Click);
			});
		}
		btnYesQuit[0].setOnAction(e -> {
			setGameMode(primaryStage);
		});

		btnYesQuit[1].setOnAction(e -> {
			System.exit(0);
		});
		
		
		vbBody.getChildren().addAll(txBody, hbBody);
		bPane.setCenter(vbBody);
		
		// </body>
		
		Scene scene = new Scene(bPane, 1120, 630);
		primaryStage.setTitle("Java UNO GAME: Congratulations");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
