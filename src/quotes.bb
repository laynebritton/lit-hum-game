Function writeQuote(quote)	
	SetFont(big_quote_font)
	Select quote
		Case 1
			SetFont(big_quote_font)
			Text 960,510,"Why is it that a person should wish to experience suffering by watching greivous and tragic",True,True
			Text 960,535, "events which he himself would not wish to endure?",True,True
			Text 960,560, "Augustine (III.1.1)",True,True
	End Select
	
	SetFont(font)
End Function

