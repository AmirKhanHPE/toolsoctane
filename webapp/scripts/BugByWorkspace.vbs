Set voFSO = CreateObject("Scripting.FileSystemObject")
vsSharedSpace=2004
voWSFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\workspaces\"
voWSBugFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\defects\"
voWSPhaseFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\phases\"
voWSListNodesFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\list_nodes\"
voWSReportFolder = "C:\Users\khanami\IdeaProjects\toolsoctane\webapp\data\report-data\"

Set voBugByWS = voFSO.CreateTextFile(voWSReportFolder & "BugByWS.txt", true)

Set voWSFiles = voFSO.GetFolder(voWSFolder).Files
voBugByWS.WriteLine "Workspace;Defect;DefectID;Severity;Phase"
For Each voWSFile in voWSFiles


'uwe the king was here and fixed issue on 3rd May 2017


    'Wscript.Echo voWSFile.Name & " - " & voWSFile.Path
	set voWorkspaces = voFSO.OpenTextFile(voWSFolder & "\workspaces.txt")
	vsLine = voWorkspaces.ReadLine
	Do Until voWorkspaces.AtEndOfStream
		vsLine = voWorkspaces.ReadLine
		vsArray = Split(vsLine,";")
		For i=0 to UBound(vsArray)
			vsWSID = vsArray(0)
			'voBugByWS.Write vsArray(1) & ";"
			Set voBugFile = voFSO.OpenTextFile(voWSBugFolder & vsWSID & "_" & vsSharedSpace & "_defects.txt")
			vsBugLine = voBugFile.ReadLine
			Do Until voBugFile.AtEndOfStream
				vsBugLine = voBugFile.ReadLine
				vsBugArray = Split(vsBugLine,";")
				'For a=0 to UBOUND(vsBugArray)
					'Msgbox UBOUND(vsBugArray) 
					vsPhaseID=vsBugArray(3)
					if UBOUND(vsBugArray)<7 then
					vsSeverityID=109284753
					else
					vsSeverityID=Right(vsBugLine,4)
					If instr(vsSeverityID,";") <> 0 then
						vsSeverityID=109284753
					end if
					end if
					Set voPhaseFile = voFSO.OpenTextFile(voWSPhaseFolder & vsWSID & "_" & vsSharedSpace & "_phases.txt")
					vsAllPhases = voPhaseFile.ReadAll
					voPhaseFile.Close
					vsPhaseCutArray = Split(vsAllPhases,vsPhaseID)
					vsPhaseArray= Split(vsPhaseCutArray(1),";")
					'voBugByWS.Write vsPhaseArray(1) & ";"
					'Msgbox vsPhaseArray(0)
					Set voNodesFile = voFSO.OpenTextFile(voWSListNodesFolder & vsWSID & "_" & vsSharedSpace & "_list_nodes.txt")
					vsAllNodes = voNodesFile.ReadAll
					voNodesFile.Close
					vsNodesCutArray = Split(vsAllNodes,vsSeverityID)
					'MSGBOX UBOUND(vsNodesCutArray) & " - " & vsSeverityID

					if UBOUND(vsNodesCutArray)=0 then
						voBugByWS.Write  vsArray(1) & ";" & vsBugArray(1) & ";" & vsBugArray(0) & ";;" & vsPhaseArray(1) & vbCrLf 
						'voBugByWS.Write ";" & vbCrLf 
					else
						vsNodesArray= Split(vsNodesCutArray(1),";")
						voBugByWS.Write  vsArray(1) & ";" & vsBugArray(1) & ";" & vsBugArray(0) & ";" & vsNodesArray(1) & ";" & vsPhaseArray(1) & vbCrLf 
						'voBugByWS.Write 
					end if
				'Next

			Loop
			voBugFile.Close
		Next
	Loop
	voWorkspaces.Close
Next
voBugByWS.Close

Msgbox "Done"