Function writeQuote(quote)	
	SetFont(big_quote_font)
	Color 255,255,255
	
	Select quote
		Case 0 
			Text 960,510,"",True,True
			Text 960,535, "",True,True
			Text 960,560, "",True,True
			
		Case 1
			Text 960,510,"Why is it that a person should wish to experience suffering by watching greivous and tragic",True,True
			Text 960,545, "events which he himself would not wish to endure?",True,True
			Text 960,575, "(Augustine, Confessions (III.1.1))",True,True
	
		Case 2
			Text 960,70, "For I am Not Aeneas, am Not Paul;",True,True
			Text 960,105, "nor I nor others think myself so worthy",True,True
			Text 960,140, "(Dante, Inferno (II.32-33))",True,True
			
	End Select
	
	SetFont(font)
End Function

