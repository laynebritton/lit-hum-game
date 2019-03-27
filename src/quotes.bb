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

	End Select
	
	SetFont(font)
End Function
