Function lagCalculation()
	current = MilliSecs()
	elapsed# = current# - previous#
	previous# = current#
	lag = lag + elapsed
End Function


Function fpsTracker()
	If MilliSecs() - fps_time_tracker# >= 1000 Then
		fps_to_display = fps_count
		fps_count = 0
		fps_time_tracker# = MilliSecs()
	End If
End Function
