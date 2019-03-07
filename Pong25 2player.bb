Graphics 640,480,0,2
SeedRnd MilliSecs()
SetBuffer BackBuffer()
While Not KeyHit(1)
	Cls
	Rect 10,P1y+220,10,40,True
	Rect 620,P2y+220,10,40,True
	Rect Bx#-5,By#-5,10,10,True
	Text 320,0,"Pong25 2 player           " + P1score + " : " + P2score + "          by Shane Kennedy (www.fractalytic.co.uk)", True
	Bx# = Bx# + 3*Cos(Bangle) + (MilliSecs() - start)*Cos(Bangle)/6000
	By# = By# + 3*Sin(Bangle) + (MilliSecs() - start)*Sin(Bangle)/6000
	If (Bx# > 615 And Bx# < 623 And Abs(P2y + 240 - By#) < 20) Or (Bx# < 25 And Bx# > 17 And Abs(P1y + 240 - By#) < 20) Then Bx# = 615 * (Bx# > 615) + 25 * (Bx# < 25)
	If (Bx# = 615 And Abs(P2y + 240 - By#) < 20) Or (Bx# = 25 And Abs(P1y + 240 - By#) < 20) Then Bangle = (180 - Abs(Bangle) - (Rand(-10,0)*(Abs(Bangle) > 10) - Rand(0,10)*(Abs(Bangle) < 170)))*Sgn(Bangle)
	If By# < 25 Or By# > 455 Then By# = 25 * (By# < 25) + 455 * (By# > 455)
	If By# = 25 Or By# = 455 Then Bangle = -Bangle 
	If Bx# < -5 Then P2score = P2score + 1
	If Bx# > 645 Then P1score = P1score + 1
	If Bx# < -5 Or Bx# > 645 Or start = 0 Then start = MilliSecs()
	If Bx# < -5 Or Bx# > 645 Or start = 0 Then Bangle = (Rand(1,60) + 120 * Rand(0,1)) * (-1 + 2*Rand(0,1))
	If Bx# < -5 Or Bx# > 645 Or start = 0 Then By# = 240
	If Bx# < -5 Or Bx# > 645 Or start = 0 Then Bx# = 320
	P1y = P1y - 3 * KeyDown(30) * (P1y > -200) + 3 * KeyDown(44) * (P1y < 200)
	P2y = P2y - 3 * KeyDown(200) * (P2y > 40) + 3 * KeyDown(208) * (P2y < 440)
	Flip
Wend
End