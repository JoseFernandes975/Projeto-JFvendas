import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';


type ChartData = { 
            series: number[];
            labels: string[]; 
           }

function DonutsChart() {

    //FORMA ERRADA
    let chartData : ChartData ={ labels: [], series: []}

    //FORMA ERRADA
     axios.get(`${BASE_URL}/sales/amount-by-seller`)
     .then(response => {
         const data = response.data as SaleSum[];
         const myLabels = data.map(x => x.sellerName)
         const mySeries = data.map(x => x.sum)

         chartData = { labels: myLabels, series: mySeries };

         console.log(chartData);
     });
   
     //const é um dado que não muda
  //  const mockData = {
     //   series: [477138, 499928, 444867, 220426, 473088],
       // labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}
    
    const options = {
        legend: {
            show: true
        }
    }
    return (
     <div>
       <Chart options={{ ...options, labels: chartData.labels}} 
              series={chartData.series}
              type='donut'
              height={240}
       />
</div>
    );
}

export default DonutsChart;