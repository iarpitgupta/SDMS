function openAssignedBatches(toggle_div_id){
		let assignedDiv = document.getElementById(toggle_div_id);
			if(assignedDiv){
				assignedDiv.classList.toggle('myResponsiveToggle');
			}
			else
			{
				console.log('Div not found');
			}
}
// JavaScript Document