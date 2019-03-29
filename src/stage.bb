Global stage_x#,stage_y#,stage_gfx
Global stage_speed#

Function loadStage(name$)
	Select name$
	Case "hell"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/9th-circle.jpg")
			box\x# = -100
			box\y# = -400
			box\base_height# = box\y#
			box\speed# = 1
			floor_level=400
			song  = LoadSound("../snd/bgm/menu.wav")

	Case "tower"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/house.jpg")
			box\x# = -300
			box\y# = -750
			box\base_height# = box\y#
			box\speed# = 3
			floor_level=500
			song  = LoadSound("../snd/bgm/montaigne.mp3")
	Case "symposium"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/symposium.jpg")
			box\x# = -300
			box\y# = 0
			box\base_height# = box\y#
			box\speed# = 3
			floor_level=500
			song  = LoadSound("../snd/bgm/videruntomnes.mp3")
	Case "troy"
		box.stage = New stage
			box\gfx = LoadImage("../img/bg/troy4.jpg")
			box\x# = -200
			box\y# = -750
			box\base_height# = box\y#
			box\speed# = 3.2
			floor_level=450
			box\floor_mod = floor_level
			song  = LoadSound("../snd/bgm/revenge.mp3")

	End Select
End Function
Function preventStageOverflow()
	For box.stage = Each stage
		If box\x# < 1920-ImageWidth(box\gfx)  Then box\x# = 1920-ImageWidth(box\gfx)
		If box\x# > 0 Then box\x# = 0 
		
		If box\y# > 0 Then stage_y# = 0
		If box\y# < box\base_height# Then box\y# = box\base_height
	Next
End Function

Function drawStage()
	For box.stage = Each stage
		trackStage()
		preventStageOverflow()
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
				
				For char2.fighter = Each fighter
				
					If char\jump_state$="FALSE" And char2\jump_state$="FALSE" Then ;char\y# < floor_level - 250 Then
						If char\able_to_jump_state$="FALSE" And char2\able_to_jump_state$="FALSE" Then
							box\y# = box\y# - Float(2*box\speed#)
						Else If char\able_to_jump_state$="TRUE" And char2\able_to_jump_state$="FALSE" Then
							box\y# = box\y# - box\speed#
						Else If char\able_to_jump_state$="TRUE" And char2\able_to_jump_state$="TRUE" Then
							box\y# = box\y# - box\speed#
						End If

						;floor_level =floor_level - Float(2*box\speed#)
					Else If char\jump_state$="TRUE" And char2\jump_state$="FALSE" Then
						box\y# = box\y# + box\speed#
						;floor_level = floor_level + box\speed#
					Else If char\jump_state$="TRUE" And char2\jump_state$="TRUE" Then
						box\y# = box\y# + ((2) * box\speed#)
						;floor_level = floor_level + Float(2*box\speed#)
					End If
				Next 
				
				;If floor_height < box\floor_mod# Then floor_height = box\floor_mod#

		Next
	Next
End Function