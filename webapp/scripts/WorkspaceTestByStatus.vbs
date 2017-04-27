Set voFSO = CreateObject("Scripting.FileSystemObject")
vsSharedSpace=2004
voWSReportFile = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\TestByWS.txt"

Set voBugByWS = voFSO.CreateTextFile("C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\TestByStatusWS.txt", true)

voBugByWS.WriteLine "Workspace;Passed;Failed;Not Completed;N/A;Planned"
'Wscript.Echo voWSFile.Name & " - " & voWSFile.Path
set voBugByWSFile = voFSO.OpenTextFile(voWSReportFile)
Passed=0:Failed=0:NotCompleted=0:NA=0:Planned=0
vsLine = voBugByWSFile.ReadLine
Do Until voBugByWSFile.AtEndOfStream
	vsLine = voBugByWSFile.ReadLine
	vaArrayLine = Split(vsLine,";")
	If Len(Trim(vsWorkspace))=0 then
		vsWorkspace=vaArrayLine(0)
	end if

	If inStr(vsLine,";") = 0 or voBugByWSFile.AtEndOfStream = True then
		'vnTotal=vnNew+vnOpened+vnDeferred+vnDuplicate+vnFixed+vnProposeClosed+vnRejected+vnClosed
		voBugByWS.WriteLine "Software Schweiz" & ";" & Passed & ";" & Failed & ";" & NotCompleted & ";" & NA & ";" & Planned
		vaArrayLine = Split(vsLine,";")
		vsWorkspace=vaArrayLine(0)
		Passed=0:Failed=0:NotCompleted=0:NA=0:Planned=0
	End if
	Select Case vaArrayLine(2)
	Case "Passed"
		Passed=Passed+1
	Case "Failed"
		Failed=Failed+1
	Case "Not Completed"
		NotCompleted=NotCompleted+1
	Case "N/A"
		NA=NA+1
	Case "Planned"
		Planned=Planned+1
	End Select
	

Loop
voBugByWSFile.Close
voBugByWS.Close

Msgbox "Done"