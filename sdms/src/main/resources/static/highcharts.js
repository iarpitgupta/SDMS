$(document).ready(function() {


Highcharts.chart('top-institute', {
  chart: {
    type: 'column'
  },
  title: {
    text: 'Top 5 states having maximum Training Centres'
  },
  subtitle: {
    text: 'Source: Our data'
  },
  xAxis: {
    categories: [
      'State1',
      'State2',
      'State3',
      'State4',
      'State5'
    ],
    crosshair: true
  },
  yAxis: {
    min: 0,
    title: {
      text: 'Number of Training Centres'
    }
  },
  tooltip: {
    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
      '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
    footerFormat: '</table>',
    shared: true,
    useHTML: true
  },
  plotOptions: {
    column: {
      pointPadding: 0.2,
      borderWidth: 0
    }
  },
  series: [{
    name: 'Training Centres',
    data: [49.9,83.6,12,40,50]

  }]
});





// Create the chart
Highcharts.chart('percentage-training', {
  chart: {
    type: 'pie'
  },
  title: {
    text: 'Total % of trainings for each job role'
  },
  subtitle: {
    text: 'Click the slices to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
  },
  plotOptions: {
    series: {
      dataLabels: {
        enabled: true,
        format: '{point.name}: {point.y:.1f}%'
      }
    }
  },

  tooltip: {
    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
  },

  "series": [
    {
      "name": "Job Role",
      "colorByPoint": true,
      "data": [
        {
          "name": "Solar lighting technician options",
          "y": 62.74,
        },
        {
          "name": "Home Lighting System Street Lights",
          "y": 10.57,
        },
        {
          "name": "Rooftop Solar Grid Engineer",
          "y": 7.23,
        },
        {
          "name": "Solar PV Installer",
          "y": 5.58,
        },
        {
          "name": "Safai Karamchari",
          "y": 4.02,
        },
        {
          "name": "Solar PV installer-electrical",
          "y": 1.92,
        }
      ]
    }
  ]
});
  
});