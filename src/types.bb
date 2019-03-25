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
	
	;Animation timers
	Field attack_timer=0
	Field breathing_timer=0
	
	;Animation
	
	;Animation frame knowledge
	Field basic_attack_timer_length=0
	Field breathing_timer_length=0
	
	;Frame counts
	Field basic_attack_frames
	
	;Physical Locations
	Field x#
	Field y#
	
	;Attack locations
	Field attack_x#=0
	Field attack_y#=0
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