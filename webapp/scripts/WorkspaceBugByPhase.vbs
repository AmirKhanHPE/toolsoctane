Set voFSO = CreateObject("Scripting.FileSystemObject")
vsSharedSpace=2004
voWSReportFile = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\BugByWS.txt"

Set voBugByWS = voFSO.CreateTextFile("C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\BugByPhasePerWS.txt", true)

voBugByWS.WriteLine "Workspace;New;Opened;Duplicate;Fixed;Propose Closed;Closed;Rejected;Deferred;Total"
'Wscript.Echo voWSFile.Name & " - " & voWSFile.Path
set voBugByWSFile = voFSO.OpenTextFile(voWSReportFile)
vnNew=0:vnOpened=0:vnDuplicate=0:vnFixed=0:vnProposeClosed=0:vnClosed=0:vnRejected=0:vnDeferred=0:vnTotal=0:vsWorkspace=""
vsLine = voBugByWSFile.ReadLine
Do Until voBugByWSFile.AtEndOfStream
	vsLine = voBugByWSFile.ReadLine
	vaArrayLine = Split(vsLine,";")
	If Len(Trim(vsWorkspace))=0 then
		vsWorkspace=vaArrayLine(0)
	end if

	If inStr(vsLine,vsWorkspace) = 0 or voBugByWSFile.AtEndOfStream = True then
		vnTotal=vnNew+vnOpened+vnDeferred+vnDuplicate+vnFixed+vnProposeClosed+vnRejected+vnClosed
		voBugByWS.WriteLine vsWorkspace & ";" & vnNew & ";" & vnOpened & ";" & vnDuplicate & ";" & vnFixed & ";" & vnProposeClosed & ";" & vnClosed & ";" & vnRejected & ";" & vnDeferred & ";" & vnTotal
		vaArrayLine = Split(vsLine,";")
		vsWorkspace=vaArrayLine(0)
		vnNew=0:vnOpened=0:vnDuplicate=0:vnFixed=0:vnProposeClosed=0:vnClosed=0:vnRejected=0:vnDeferred=0:vnTotal=0
	End if
	Select Case vaArrayLine(4)
	Case "New"
		vnNew=vnNew+1
	Case "Opened"
		vnOpened=vnOpened+1
	Case "Duplicate"
		vnDuplicate=vnDuplicate+1
	Case "Fixed"
		vnFixed=vnFixed+1
	Case "Propose Closed"
		vnProposeClosed=vnProposeClosed+1
	Case "Closed"
		vnClosed=vnClosed+1
	Case "Rejected"
		vnRejected=vnRejected+1
	Case "Deferred"
		vnDeferred=vnDeferred+1
	End Select
	

Loop
voBugByWSFile.Close
voBugByWS.Close

Msgbox "Done"