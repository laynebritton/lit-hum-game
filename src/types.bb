Type Fighter
	;Data
	Field name$
	Field player
	Field playerMultiplier=1
	;Graphics
	Field body
	Field head
	Field arm
	Field attack1
	
	;Animation
	Field breathing#
	Field breathingSpeed#
	Field breathingDirection$
	Field attackAnimFrame = 0
	
	;Physical Locations
	Field x#
	Field y#
	
	;Stats
	Field hp
	Field strength
	Field speed#
	
	;Sounds
	Field swing_sound
	Field basic_hit_sound
	
	;Game State
	Field state$="NONE"
	Field attacking

End Type