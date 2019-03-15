Function gravity(strength#,height)
	For char.fighter = Each fighter
		If char\y# < height Then
			char\y# = char\y# + strength#
		End If
	Next
End Function

Function moveFighterX(direction$,player)
	For char.fighter = Each fighter
		If char\player = player Then
			If direction$ = "LEFT" Then
				char\x# = char\x# - char\speed#
			Else If direction$ = "RIGHT" Then
				char\x# = char\x# + char\speed#
			End If
		End If
	Next
End Function

Function moveFighterY(direction$,player)
	For char.fighter = Each fighter
		If char\player = player Then
			If direction$ = "UP" Then
				char\y# = char\y# - char\speed#
			Else If direction$ = "DOWN" Then
				char\y# = char\y# + char\speed#
			End If
		End If
	Next
End Function

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
	If KeyDown(17) Then
		;Player 1 Move Up
		moveFighterY("UP",1)
	End If
	
	If KeyDown(31) Then
		;Player 1 Move Down
		moveFighterY("DOWN",1)
	End If

	If KeyDown(30) Then
		;Player 1 Move Left
		moveFighterX("LEFT",1)
	End If
	
	If KeyDown(32) Then
		;Player 1 Move Right
		moveFighterX("RIGHT",1)
	End If
	
	;Player 2 Movement
	If KeyDown(200) Then
		;Player 1 Move Up
		moveFighterY("UP",2)
	End If
	
	If KeyDown(208) Then
		;Player 1 Move Down
		moveFighterY("DOWN",2)
	End If

	If KeyDown(203) Then
		;Player 1 Move Left
		moveFighterX("LEFT",2)
	End If
	
	If KeyDown(205) Then
		;Player 1 Move Right
		moveFighterX("RIGHT",2)
	End If
	
	
End Function 
