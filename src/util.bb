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