Set voFSO = CreateObject("Scripting.FileSystemObject")
vsSharedSpace=2004
'voWSFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\workspaces\"
voWSTestFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\runs\manual_runs\10001_2004_manual_runs.txt"
'voWSPhaseFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\phases\"
voWSListNodesFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\list_nodes\10001_2004_list_nodes.txt"
voWSReportFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\"

Set voBugByWS = voFSO.CreateTextFile(voWSReportFolder & "TestByWS.txt", true)
'some code here'
'Set voWSFiles = voFSO.GetFolder(voWSFolder).Files
voBugByWS.WriteLine "Runid;Test;Status"
'For Each voWSFile in voWSFiles
'changed on 3rd may 2017
    'Wscript.Echo voWSFile.Name & " - " & voWSFile.Path
	set voRunsManual = voFSO.OpenTextFile(voWSTestFolder)
	vsLine = voRunsManual.ReadLine
	Do Until voRunsManual.AtEndOfStream
		vsLine = voRunsManual.ReadLine
		vsArray = Split(vsLine,";")
		'For i=0 to UBound(vsArray)
			'vsWSID = vsArray(0)
			'voBugByWS.Write vsArray(1) & ";"
			Set voListNodesFile = voFSO.OpenTextFile(voWSListNodesFolder)
			vsListNodesLine = voListNodesFile.ReadLine
			'vsLine = voRunsManual.ReadLine
			vaArray = Split(vsLine,";")
			Do Until voListNodesFile.AtEndOfStream
				vsBugLine = voListNodesFile.ReadLine
				vsBugArray = Split(vsBugLine,";")
				'For a=0 to UBOUND(vsBugArray)
					'Msgbox UBOUND(vsBugArray) 
					vsStatusID=vaArray(4)
					'Msgbox vaArray(4)
					'Msgbox vsBugArray(0)
					If vsStatusID=vsBugArray(0) then
						vsStatus=vsBugArray(1)
						exit Do
						else
						vsStatus="N/A"
					end if
					'voBugByWS.Write vsPhaseArray(1) & ";"
					'Msgbox vsPhaseArray(0)
					'MSGBOX UBOUND(vsNodesCutArray) & " - " & vsSeverityID

					'voBugByWS.Write  vsArray(0) & ";" & vsArray(1) & ";" & vsStatus & vbCrLf 
				'Next

			Loop
			'voBugFile.Close
			voListNodesFile.close
			voBugByWS.Write  vsArray(0) & ";" & vsArray(1) & ";" & vsStatus & vbCrLf 

		'Next
	Loop
	voRunsManual.Close
'	voWorkspaces.Close
'Next
voBugByWS.Close

Msgbox "Done"