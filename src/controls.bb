Function checkInput()
	;Kill-program 
	If KeyHit(1) Then
		End
	End If
	
	;Toggle FPS Display
	If KeyHit(2) Then
		toggleFpsDisplay()
	End If
	
	If KeyHit(3) Then
		togglePlayer1Coords()
	End If
	
	;Start functionality
	If KeyHit(player1_start) Then
		If game_state$="END" Then
			clearFight()
		End If
	End If
	
	;Player 1 Movement
	If KeyHit(player1_jump) Then
		;Player 1 Move Up
		;moveFighterY("UP",1)
		;moveStageY(-10)
		jump(1)
	End If
	
	If KeyDown(player1_down) Then
		;Player 1 Move Down
		;moveFighterY("DOWN",1)
		;moveStageY(10)
		crouch(1)
	Else 
		uncrouch(1)
	End If

	If KeyDown(player1_left) Then
		;Player 1 Move Left
		moveFighterX("LEFT",1)
		;moveStageX(-10)
	End If
	
	If KeyDown(player1_right) Then
		;Player 1 Move Right
		;moveStageX(10)
		moveFighterX("RIGHT",1)
	End If
	
	;Player 1 Actions
	If KeyHit(player1_attack) Then
		basicAttack(1)
	End If
	
	If KeyHit(player1_throw) Then
		createProjectile(1)
	End If
	
	;Player 2 Movement
	If KeyHit(player2_jump) Then
		;Player 2 Move Up
		;moveFighterY("UP",2)
		jump(2)
	End If
	
	If KeyDown(player2_down) Then
		;Player 2 Move Down
		;moveFighterY("DOWN",2)
		crouch(2)
	Else 
		uncrouch(2)
	End If

	If KeyDown(player2_left) Then
		;Player 2 Move Left
		moveFighterX("LEFT",2)
	End If
	
	If KeyDown(player2_right) Then
		;Player 2 Move Right
		moveFighterX("RIGHT",2)
	End If
	
		;Player 2 Actions
	If KeyHit(player2_attack) Then
		basicAttack(2)
	End If
	
	If KeyHit(player2_throw) Then
		createProjectile(2)
	End If
	
	
End Function 