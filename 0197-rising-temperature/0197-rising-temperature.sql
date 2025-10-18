select t.id
from weather t cross join weather r
where datediff(t.recordDate,r.recordDate)=1
    and t.temperature >r.temperature ;
