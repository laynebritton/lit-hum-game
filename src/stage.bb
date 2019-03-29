Global stage_x#,stage_y#,stage_gfx
Global stage_speed#

Function loadStage(name$)
	Select name$
	Case "hell"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/9th-circle.jpg")
			box\x# = -100
			box\y# = -400
			box\speed# = 1
			floor_level=400
			song  = LoadSound("../snd/bgm/menu.wav")

	Case "tower"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/house.jpg")
			box\x# = -300
			box\y# = -750
			box\speed# = 3
			floor_level=500
			song  = LoadSound("../snd/bgm/montaigne.mp3")
	Case "symposium"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/symposium.jpg")
			box\x# = -300
			box\y# = 0
			box\speed# = 3
			floor_level=500
			song  = LoadSound("../snd/bgm/videruntomnes.mp3")
	Case "troy"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/troy4.jpg")
			box\x# = -200
			box\y# = -750
			box\speed# = 3.2
			floor_level=450
			song  = LoadSound("../snd/bgm/revenge.mp3")

	End Select
End Function
Function preventStageOverflow()
	For box.stage = Each stage
		If box\x# < 1920-ImageWidth(box\gfx)  Then box\x# = 1920-ImageWidth(box\gfx)
		If box\x# > 0 Then box\x# = 0 
		;If stage_x# > ImageWidth(stage_gfx) - 1920  Then stage_x = 0
		;If stage_y# < 0 Then stage_y# = 0
		;If stage_x# > ImageWidth(stage_gfx) - 1920  Then stage_x = 0
	Next
End Function

Function drawStage()
	For box.stage = Each stage
		preventStageOverflow()
		trackStage()
		DrawImage(box\gfx,box\x#,box\y#,0)
	Next 
End Function

;Function moveStageX(amount#);
;	stage_x# = stage_x# + amount#
;End Function

;Function moveStageY(amount#)
;	stage_y# = stage_y# + amount#
;End Function

Function trackStage()
	For box.stage = Each stage
		For char.fighter = Each fighter
				If char\player = 1 Then
					If char\x <= 400 And char\movement_state$="LEFT" Then
						box\x# = box\x# + box\speed#
						;moveStageX(Float((-1) * stage_speed#))
					End If
				End If
				
				If char\player = 2 Then
					If char\x >= 1520 And char\movement_state$="RIGHT" Then
						box\x# = box\x# - box\speed#
						;moveStageX(stage_speed#)
					End If
				End If
		Next
	Next
End Function