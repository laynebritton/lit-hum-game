Function createFighter(fighterName$,player)

	Select fighterName$
	
	Case "Dante"
	;Dante
		char.fighter = New Fighter
			;Data
			char\name$ = "Dante"	
			char\player = player
			
			;Location		
			char\x = 490
			char\y = 600
			
			;Stats
			char\hp = 100
			char\strength = 5
			char\speed = 10
			
			;Graphics
			char\body = LoadImage("../img/Dante/dante-resized.png")
			MaskImage(char\body,255,0,220)
			
			If player = 2 Then
				char\x = 1430
				mirrorImage(char\body)
				
			End If
	
	End Select
	
End Function