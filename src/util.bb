Function mirrorImage(image)
	TFormImage(image,0,1,1,0)
	RotateImage(image,90)
	HandleImage(image,0,0)
End Function

Function offsetCalculator(amount#, player)
	If player = 2 Then
		Return (-1)*amount#
	Else 
		Return amount#
	End If
End Function 

Function deleteProjectiles()
	For entity.projectile = Each Projectile
		If entity\toDelete = True Then
			For char.fighter = Each Fighter
				If entity\player = char\player Then
					char\projectile_count = char\projectile_count - 1
				End If
			Next
			Delete entity
		End If
	Next
End Function