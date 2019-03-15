Function basic_attack_collisions()
	For char.fighter = Each fighter
		For char2.fighter = Each fighter
			If (Not char\player# = char2\player#) And ImagesCollide(char\attack1, char\x,char\y, 0, char2\body, char2\x, char2\y, 0)  Then
				;Rect 0,0,200,200,1
			End If
		Next
	Next
End Function