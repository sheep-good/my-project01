async function fetchTable(dan, op) {
  const res = await fetch(`/api/tables/${dan}?op=${op}`);
  if (!res.ok) throw new Error('서버 오류');
  return await res.json();
}

function render(data) {
  const container = document.getElementById('result');
  if (!data?.rows?.length) {
    container.innerHTML = '<p>결과가 없습니다.</p>';
    return;
  }
  const rows = data.rows.map(
    r => `<tr><td>${r.left}</td><td>${r.op === 'mul' ? 'x' : '÷'}</td><td>${r.right}</td><td>=</td><td>${r.op === 'mul' ? r.value : r.value.toFixed(2)}</td><td>${r.expr}</td></tr>`
  ).join('');
  container.innerHTML = `
    <h3>${data.dan}단 (${data.op === 'mul' ? '곱셈' : '나눗셈'})</h3>
    <table>
      <thead><tr><th>좌항</th><th>연산</th><th>우항</th><th></th><th>값</th><th>표현</th></tr></thead>
      <tbody>${rows}</tbody>
    </table>
  `;
}

/*조회*/
document.getElementById('btn').addEventListener('click', async () => {
  const dan = parseInt(document.getElementById('dan').value, 10);
  const op = document.getElementById('op').value;
  if (Number.isNaN(dan) || dan < 1) {
    alert('단은 1 이상의 정수로 입력하세요.');
    return;
  }
  try {
    const data = await fetchTable(dan, op);
    render(data);
  } catch (e) {
    console.error(e);
    alert('조회 중 오류가 발생했습니다.');
  }
});

// 초기 로드
window.addEventListener('DOMContentLoaded', () => {
  //document.getElementById('btn').click();
});
