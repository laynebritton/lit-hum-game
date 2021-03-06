Function writeQuote(quote)	
	SetFont(big_quote_font)
	Color 255,255,255
	
	Select quote
		Case 0 
			Text 960,70,Chr(34) + "",True,True
			Text 960,105, "",True,True
			Text 960,140, ""+ Chr(34),True,True
			Text 960,175, "",True,True
			
		Case 1
			Text 960,510, Chr(34) + "Why is it that a person should wish to experience suffering by watching greivous and tragic",True,True
			Text 960,545, "events which he himself would not wish to endure?" + Chr(34),True,True
			Text 960,575, "(Augustine, Confessions (III.1.1))",True,True
	
		Case 2
			Text 960,70, Chr(34) + "For I am Not Aeneas, am Not Paul;",True,True
			Text 960,105, "nor I nor others think myself so worthy"+ Chr(34),True,True
			Text 960,140, "-Dante (Dante, Inferno (II.32-33))",True,True
			
		Case 3
			Text 960,70,Chr(34) + "But in the end, his evil arts will not prevail against the power of my virtuous sword.",True,True
			Text 960,105, "-Don Quixote (Cervantes, Don Quixote (I.VII)"+ Chr(34),True,True
			Text 960,140, "",True,True
		
		Case 4 
			Text 960,70,Chr(34) + "I wish only that my spirit and fury would drive me",True,True
			Text 960,105, "to hack your meat away and eat it raw for the things that",True,True
			Text 960,140, "you have done to me."+ Chr(34),True,True
			Text 960,175, "-Achilleus (Homer, Iliad (22.346-388))",True,True
		
		Case 5 
			Text 960,70,Chr(34) + "If libations were proper to pour above the slain,",True,True
			Text 960,105, "this man deserved, more than deserved, such sacrament." + Chr(34),True,True
			Text 960,140, "-Clytaemestra (Aeschylis, Agamemnon (1395-1396))",True,True

		Case 6
			Text 960,70,Chr(34) + "It is not pious, gloating over men",True,True
			Text 960,105, "who have been killed. Divine fate took them down,",True,True
			Text 960,140, "and their own wicked deeds."+ Chr(34),True,True
			Text 960,175, "-Odysseus (Homer, The Odyssey (22.411-413))",True,True
		
		Case 7
			Text 960,70,Chr(34) + "I am set to face",True,True
			Text 960,105, "Aeneas, set to suffer death in all",True,True
			Text 960,140, "its bitterness"+ Chr(34),True,True
			Text 960,175, "-Turnus (Virgil, The Aeneid(12.902-904))",True,True
		
		Case 8
			Text 960,70,Chr(34) + "If what I have hitherto said can appear to you",True,True
			Text 960,105, "in the form of encouragement, I know not how to express my refusal",True,True
			Text 960,140, "in such a way as may convince you of it being one."+ Chr(34),True,True
			Text 960,175, "-Elizabeth (Austen, Pride and Prejudice(I.XIX))",True,True
		Case 9
			Text 960,70,Chr(34) + "Abolish his own works. This would surpass",True,True
			Text 960,105, "common revenge, and interrupt his joy" + Chr(34),True,True
			Text 960,140, "-Satan (Milton, Paradise Lost (II.370-371))",True,True
		Case 10
			Text 960,70,Chr(34) + "Salvation's light is in our hands' work, not the mercy of battle"+ Chr(34),True,True
			Text 960,105, "-Aias (Homer, Iliad (15.741))",True,True
	End Select
	
	SetFont(font)
End Function