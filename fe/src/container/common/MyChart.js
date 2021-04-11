const BarChart= ()=> {
    const selected= useParams();
    const [data, setData]= useState({ labels: [], datasets: [] });
    const [loaded, setLoaded]= useState(false);
    useEffect(()=> {
      axios
        .get(`http://localhost:8080/users/${selected.userNum}`)
        .then(res=> {
          if (loaded=== false) {
            //Bar Graph
            const data= {
              labels: [
                'painting',
                'media',
                'sculpture',
                'craft',
                'installation',
              ],
              datasets: [
                {
                  label: 'users prefer genre',
                  data: [
                    res.data.segments[0].stats.painting.displayValue,
                    res.data.segments[0].stats.media.displayValue,
                    res.data.segments[0].stats.sculpture.displayValue,
                    res.data.segments[0].stats.craft.displayValue,
                    res.data.segments[0].stats.installation.displayValue,
                  ],
                  backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                  ],
                },
              ],
            };
            setLoaded(true);
            setData(data);
          }
        })
        .catch(error=> {
          console.log(error);
        });
    }, []);
    if (loaded=== false) {
      return loaded;
    } else {
      return (
        <div className='chart'>        {data &amp;
  &amp;
   (
            <Bar
              redraw
              data={data}
              width={350}
              height={350}
              options={{
                maintainAspectRatio: true,
              }}
            />        )}
        </div>    );
    }
  };
  export default BarChart;