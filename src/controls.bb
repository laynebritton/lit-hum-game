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
	
	;Player 1 Movement
	If KeyHit(47) Then
		;Player 1 Move Up
		;moveFighterY("UP",1)
		;moveStageY(-10)
		jump(1)
	End If
	
	If KeyDown(31) Then
		;Player 1 Move Down
		;moveFighterY("DOWN",1)
		;moveStageY(10)
		crouch(1)
	Else 
		uncrouch(1)
	End If

	If KeyDown(30) Then
		;Player 1 Move Left
		moveFighterX("LEFT",1)
		;moveStageX(-10)
	End If
	
	If KeyDown(32) Then
		;Player 1 Move Right
		;moveStageX(10)
		moveFighterX("RIGHT",1)
	End If
	
	;Player 1 Actions
	If KeyHit(33) Then
		basicAttack(1)
	End If
	
	If KeyHit(46) Then
		createProjectile(1)
	End If
	
	;Player 2 Movement
	If KeyHit(51) Then
		;Player 2 Move Up
		;moveFighterY("UP",2)
		jump(2)
	End If
	
	If KeyDown(208) Then
		;Player 2 Move Down
		;moveFighterY("DOWN",2)
		crouch(2)
	Else 
		uncrouch(2)
	End If

	If KeyDown(203) Then
		;Player 2 Move Left
		moveFighterX("LEFT",2)
	End If
	
	If KeyDown(205) Then
		;Player 2 Move Right
		moveFighterX("RIGHT",2)
	End If
	
		;Player 2 Actions
	If KeyHit(37) Then
		basicAttack(2)
	End If
	
	If KeyHit(50) Then
		createProjectile(2)
	End If
	
	
End Function 